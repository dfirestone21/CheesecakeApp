package com.example.mycheesecakes.data.cache.model

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mycheesecakes.domain.model.Quiz
import com.example.mycheesecakes.domain.model.quiz.Question

data class CachedQuizAggregate(
    @Embedded
    val quiz: CachedQuiz,
    /**
     * Models the One-to-Many relationship between a Quiz and its Questions
     */
    @Relation(
        parentColumn = "id",
        entityColumn = "quiz_id"
    )
    val questions: List<CachedQuestion>,
    /**
     * One-to-One relationship of Quiz and QuizResult
     */
    @Relation(
        parentColumn = "id",
        entityColumn = "quiz_id"
    )
    val quizResult: CachedQuizResult? = null
) {

    val isComplete: Boolean
    get() = quizResult != null

    fun toDomain(): Quiz {
        return Quiz(
            id = quiz.id,
            correct = quiz.correct,
            incorrect = quiz.incorrect,
            questions = questions.map { it.toDomain() },
            questionIndex = quiz.questionIndex
        )
    }

    companion object {
        fun fromDomain(quiz: Quiz): CachedQuizAggregate {
            return CachedQuizAggregate(
                quiz = CachedQuiz.fromDomain(quiz),
                questions = quiz.questions.map { CachedQuestion.fromDomain(quiz.id,it) },
                quizResult = if (quiz.quizResult != null) CachedQuizResult.fromDomain(quiz.quizResult!!) else null
            )
        }
    }
}