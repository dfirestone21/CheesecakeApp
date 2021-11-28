package com.example.mycheesecakes.data.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mycheesecakes.domain.model.quiz.Question

@Entity
data class CachedQuestion(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "quiz_id")
    val quizId: Int = 0,
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
        fun fromDomain(question: Question): CachedQuestion {
            return CachedQuestion(
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
