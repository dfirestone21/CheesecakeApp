package com.example.mycheesecakes.domain.model

import com.example.mycheesecakes.data.cache.model.CachedQuestion
import com.example.mycheesecakes.data.cache.model.CachedQuiz
import com.example.mycheesecakes.data.cache.model.CachedQuizAggregate
import com.example.mycheesecakes.data.cache.model.CachedQuizResult
import com.example.mycheesecakes.domain.model.quiz.*
import com.example.mycheesecakes.utils.NanoIdUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

class Quiz(
    val id: String = NanoIdUtils.randomNanoId(),
    val questions: List<Question>,
    var questionIndex: Int = 0,
    var correct: Int = 0,
    var incorrect: Int = 0
){
    private var currentQuestion: Question = questions[questionIndex]
    val size: Int
        get() = questions.size
    var quizResult: QuizResult? = null
    lateinit var timer: QuizTimer
    var isComplete: Boolean = questionIndex == questions.lastIndex

    /**
     * Used for restarting the timer with previous time.
     */
    private var timeRemainingOnPause: Long = 0


    fun getNextQuestion(): Question? {
        if (isComplete || questionIndex < 0 || questionIndex > questions.lastIndex) {
            return null
        }
        currentQuestion = questions[questionIndex]
        timer = QuizTimer()
        timer.start()
        return currentQuestion
    }

    fun onQuestionAnswered(answer: String) {
        timer.cancel()
        currentQuestion.answer = answer
        if (currentQuestion.isCorrect) {
            correct++
        } else {
            incorrect++
        }
        questionIndex++
    }

    fun answerResponse(): String =
        if (currentQuestion.isCorrect) {
            "Correct!"
        } else {
            "Incorrect: ${currentQuestion.correctAnswer}"
        }


    fun timeExpired() {
        timer.cancel()
        onQuestionAnswered(currentQuestion.answer)
    }

    fun quizComplete(): QuizResult {
        timer.cancel()
        isComplete = true
        quizResult = QuizResult(
            score = Score(correct,incorrect),
            date = Date().time,
            quizId = id
        )
        return quizResult as QuizResult
    }

    fun pauseQuiz() {
        timeRemainingOnPause = timer.timeRemaining
        timer.cancel()
    }

    fun resumeQuiz() {
        timer.cancel()
        timer = QuizTimer(timeRemainingOnPause)
        timer.start()
    }

}


