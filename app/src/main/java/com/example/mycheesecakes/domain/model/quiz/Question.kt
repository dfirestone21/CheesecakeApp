package com.example.mycheesecakes.domain.model.quiz


data class Question(
    val id: Int = 0,
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
