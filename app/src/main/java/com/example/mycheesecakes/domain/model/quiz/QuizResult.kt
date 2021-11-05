package com.example.mycheesecakes.domain.model.quiz

import java.util.*

data class QuizResult(
    val score: Score,
    val date: Long,
    val id: Int? = null
) {
}