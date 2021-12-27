package com.example.mycheesecakes.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.mycheesecakes.domain.model.quiz.Question

@Entity(
    tableName = "questions",
    foreignKeys = [
        ForeignKey(
            entity = CachedQuiz::class,
            parentColumns = ["id"],
            childColumns = ["quiz_id"],
            onDelete = ForeignKey.CASCADE
        )
    ])
data class CachedQuestion(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "quiz_id")
    val quizId: String,
    @ColumnInfo(name = "item_name")
    val itemName: String,
    @ColumnInfo(name = "item_image_url")
    val itemImageURL: String,
    val question: String,
    val answers: String,
    @ColumnInfo(name = "correct_answer")
    val correctAnswer: String,
    var answer: String = "",
    @ColumnInfo(name = "is_correct")
    var isCorrect: Boolean = false
) {

    fun toDomain(): Question {
        return Question(
            itemName = itemName,
            itemImageURL = itemImageURL,
            question = question,
            answers = jsonToList(answers),
            correctAnswer = correctAnswer
        )
    }

    companion object {
        fun fromDomain(quizId: String, question: Question): CachedQuestion {
            return CachedQuestion(
                id = question.id,
                quizId = quizId,
                itemName = question.itemName,
                itemImageURL = question.itemImageURL,
                question = question.question,
                answers = listToJson(question.answers),
                correctAnswer = question.correctAnswer,
                answer = question.answer,
                isCorrect = question.isCorrect
            )
        }
    }
}
