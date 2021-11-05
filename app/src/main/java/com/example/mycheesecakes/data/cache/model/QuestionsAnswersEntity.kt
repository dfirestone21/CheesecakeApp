package com.example.mycheesecakes.data.cache.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.mycheesecakes.domain.model.quiz.Question

@Entity(
    tableName = "quiz_answers",
    indices = [Index("question")]
)
data class QuestionsAnswersEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val question: String?,
    val answer: String?
)
