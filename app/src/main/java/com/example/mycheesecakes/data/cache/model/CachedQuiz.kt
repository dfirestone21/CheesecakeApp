package com.example.mycheesecakes.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mycheesecakes.domain.model.Quiz
import com.example.mycheesecakes.domain.model.quiz.Question
import com.example.mycheesecakes.domain.model.quiz.QuizResult

@Entity(tableName = "quizzes")
data class CachedQuiz(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "question_index")
    var questionIndex: Int,
    var correct: Int,
    var incorrect: Int,
    @ColumnInfo(name = "is_complete")
    val isComplete: Boolean
) {
    companion object {
        fun fromDomain(quiz: Quiz): CachedQuiz {
            return CachedQuiz(
                id = quiz.id,
                questionIndex = quiz.questionIndex,
                correct = quiz.correct,
                incorrect = quiz.incorrect,
                isComplete = quiz.isComplete
            )
        }
    }
}