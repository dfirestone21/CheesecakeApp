package com.example.mycheesecakes.domain.model.quiz

import android.os.CountDownTimer
import kotlinx.coroutines.flow.MutableStateFlow

class QuizTimer(var timeRemaining: Long = 30000, countDownInterval: Long = 1000): CountDownTimer(timeRemaining, countDownInterval) {

    val timeFlow = MutableStateFlow(timeRemaining.toInt()/1000)

    override fun onTick(millisUntilFinished: Long) {
        //timeRemaining is used for restarting the timer
        timeRemaining = millisUntilFinished
        timeFlow.value = (millisUntilFinished/1000).toInt()
    }

    override fun onFinish() {

    }


}