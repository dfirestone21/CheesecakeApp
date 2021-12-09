package com.example.mycheesecakes.domain.model

import com.example.mycheesecakes.data.cache.model.CachedQuestion
import com.example.mycheesecakes.data.cache.model.CachedQuiz
import com.example.mycheesecakes.data.cache.model.CachedQuizAggregate
import com.example.mycheesecakes.data.cache.model.CachedQuizResult
import com.example.mycheesecakes.domain.model.quiz.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.util.*

data class Quiz(
    private val id: Int = 0,
    private val questions: List<Question>,
    private var questionIndex: Int = 0
){
    private var correct = 0
    private var incorrect = 0
    private var currentQuestion: Question = questions[questionIndex]
    val size: Int
        get() = questions.size
    private var quizResult: QuizResult? = null
    lateinit var timer: QuizTimer
    private var isComplete: Boolean = questionIndex == questions.lastIndex

    /**
     * Used for restarting the timer with previous time.
     */
    private var timeRemainingOnPause: Long = 0


    fun getNextQuestion(): Question? {
        if (isComplete || questionIndex < 0 || questionIndex > questions.lastIndex) {
            return null
        }
        currentQuestion = questions[questionIndex]
        questionIndex++
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
        quizResult = getQuizResult()
        return quizResult!!
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

    fun getCachedQuizAggregate(): CachedQuizAggregate {
        return CachedQuizAggregate(
            quiz = CachedQuiz(
                questionIndex = questionIndex,
                correct = correct,
                incorrect = incorrect,
                isComplete = isComplete
            ),
            questions = questions.map { CachedQuestion.fromDomain(it) },
            quizResult = if (quizResult != null) CachedQuizResult.fromDomain(quizResult!!) else null
        )
    }


    private fun getQuizResult() = QuizResult(
        score = Score(correct,incorrect),
        date = Date().time,
        quizId = id)
}


