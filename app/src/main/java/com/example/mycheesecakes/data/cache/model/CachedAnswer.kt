package com.example.mycheesecakes.data.cache.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.mycheesecakes.domain.model.quiz.Question

@Entity(
    tableName = "questions_and_answers",
    primaryKeys = ["question", "answer"]
)
data class CachedAnswer(
    val question: String,
    val answer: String
)
