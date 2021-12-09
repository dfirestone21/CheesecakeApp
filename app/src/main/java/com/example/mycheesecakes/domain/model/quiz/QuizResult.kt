package com.example.mycheesecakes.domain.model.quiz

data class QuizResult(
    val score: Score,
    val date: Long,
    val id: Int = 0,
    val quizId: Int
) {
}