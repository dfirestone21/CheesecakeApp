package com.example.mycheesecakes.domain.model.quiz

import android.util.Log
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.ui.quiz.TAG
import kotlin.properties.Delegates

data class Question(
    val itemName: String,
    val itemImageURL: String,
    val question: String,
    val answers: List<String>,
    val correctAnswer: String
) {

    private var correct = false
    private var answer = ""
}
