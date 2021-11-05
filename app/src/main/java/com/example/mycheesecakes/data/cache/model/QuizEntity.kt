package com.example.mycheesecakes.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mycheesecakes.domain.model.quiz.Question
import com.example.mycheesecakes.domain.model.quiz.QuizResult

@Entity(tableName = "quizzes")
data class QuizEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val questions: List<Question>,
    var correct: Int,
    var incorrect: Int,
    var questionIndex: Int,
    @ColumnInfo(name = "quiz_result")
    val quizResult: QuizResult? = null
) {
}