package com.example.mycheesecakes.domain.model

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.mycheesecakes.data.network.RetrofitInstance
import com.example.mycheesecakes.data.network.api.model.mappers.ApiCheesecakeMapper
import com.example.mycheesecakes.data.network.api.model.mappers.ListMapperImpl
import com.example.mycheesecakes.domain.model.quiz.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.util.*

class Quiz(
    private val questions: List<Question>,
    private var questionIndex: Int = 0
){
    private var correct = 0
    private var incorrect = 0
    private var currentQuestion: Question = questions[questionIndex]
    val size: Int
        get() = questions.size
    private lateinit var quizResult: QuizResult
    lateinit var timer: QuizTimer
    private var timeRemainingOnPause: Long = 0


    fun getNextQuestion(): Question? {
        if (questionIndex < 0 || questionIndex > questions.lastIndex) {
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

    fun timeExpired() {
        timer.cancel()
        onQuestionAnswered(currentQuestion.answer)
    }

    fun quizComplete(): QuizResult {
        timer.cancel()
        quizResult = getQuizResult()
        return quizResult
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


    private fun getQuizResult() = QuizResult(Score(correct,incorrect), Date().time)

}


