package com.example.mycheesecakes.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mycheesecakes.domain.model.Quiz
import com.example.mycheesecakes.domain.model.quiz.Question
import com.example.mycheesecakes.domain.model.quiz.QuizResult

@Entity(tableName = "quizzes")
data class CachedQuiz(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "question_index")
    var questionIndex: Int,
    var correct: Int,
    var incorrect: Int,
    @ColumnInfo(name = "is_complete")
    val isComplete: Boolean
) {
}