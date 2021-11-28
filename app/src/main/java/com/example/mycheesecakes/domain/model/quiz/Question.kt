package com.example.mycheesecakes.domain.model.quiz

import android.os.CountDownTimer
import android.util.Log
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.ui.quiz.TAG
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.*
import kotlin.properties.Delegates

data class Question(
    val itemName: String,
    val itemImageURL: String,
    val question: String,
    val answers: List<String>,
    val correctAnswer: String
) {
    var answer = ""
    val isCorrect
    get() = answer == correctAnswer
}
