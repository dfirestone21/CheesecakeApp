package com.example.mycheesecakes.domain.model

import android.os.CountDownTimer
import com.example.mycheesecakes.domain.model.menuitems.MenuItem
import com.example.mycheesecakes.domain.model.quiz.Question
import com.example.mycheesecakes.domain.model.quiz.QuizResult
import com.example.mycheesecakes.domain.model.quiz.Score
import java.util.*

class Quiz(questions: List<Question>) {
    var correct = 0
    var incorrect = 0

    fun onQuizComplete(): QuizResult {
        return QuizResult(
            score = Score(correct,incorrect),
            date = Date()
        )
    }

    open inner class QuestionTimer(var totalTime: Long = 30000, tickTime: Long = 1000) : CountDownTimer(totalTime, tickTime) {

        override fun onTick(millisUntilFinished: Long) {
            totalTime = millisUntilFinished
            //_questionTimerLiveData.value = (millisUntilFinished/1000).toInt()
        }

        override fun onFinish() {
            incorrect++
            //onTimeExpired()
        }
    }

}


