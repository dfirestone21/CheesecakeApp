package com.example.mycheesecakes.domain.model

import android.util.Log
import com.example.mycheesecakes.ui.quiz.TAG

data class Quiz(
    val cheesecakes: List<Cheesecake>
) {
    var numCorrect = -1
    var numIncorrect = -1
    var score: Double = -1.0
        get() = (numCorrect.toDouble() / numIncorrect)
}

data class Question(
    val cheesecake: Cheesecake,
    val question: String,
    val answers: Set<String>
    ) {

    private var correct: Boolean? = null
    val answer: String
    get() = getCorrectAnswer()



    private fun getCorrectAnswer(): String {
        Log.i(TAG,"getCorrectAnswer called")
        return when (question) {
            "Cheesecake" -> cheesecake.cheesecake
            "Crust" -> cheesecake.crust
            "Nuts" -> cheesecake.nuts.name
            "Dollops" -> cheesecake.dollops
            "Topping" -> cheesecake.topping
            "Presentation" -> cheesecake.presentation
            else -> "Error"
        }
    }
}
