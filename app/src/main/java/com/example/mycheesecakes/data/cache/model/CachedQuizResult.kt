package com.example.mycheesecakes.data.cache.model

import androidx.room.*
import com.example.mycheesecakes.domain.model.quiz.QuizResult
import com.example.mycheesecakes.domain.model.quiz.Score

@Entity(tableName = "quiz_results",
        foreignKeys = [ForeignKey(
            entity = CachedQuiz::class,
            parentColumns = ["id"],
            childColumns = ["quiz_id"],
            onDelete = ForeignKey.CASCADE
        )],
    indices = [Index("quiz_id")]
)
data class CachedQuizResult(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "quiz_id")
    val quizId: Int,
    val date: Long,
    val correct: Int,
    val incorrect: Int
) {
    companion object {
        fun fromDomain(quizResult: QuizResult): CachedQuizResult {
            return CachedQuizResult(
                id = quizResult.id,
                quizId = quizResult.quizId,
                date = quizResult.date,
                correct = quizResult.score.correct,
                incorrect = quizResult.score.incorrect
            )
        }
    }

    fun toDomain(): QuizResult {
        return QuizResult(
            score = Score(correct, incorrect),
            date = date,
            id = id,
            quizId = quizId
        )
    }
}