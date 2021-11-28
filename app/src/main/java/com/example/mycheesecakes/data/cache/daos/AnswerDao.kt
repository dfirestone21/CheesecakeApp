package com.example.mycheesecakes.data.cache.daos

import androidx.room.*
import com.example.mycheesecakes.data.cache.model.CachedAnswer

@Dao
interface AnswerDao {
    @Query("SELECT * FROM questions_and_answers WHERE question =:question AND answer != :correctAnswer ORDER BY RANDOM() LIMIT 3")
    suspend fun getIncorrectAnswersForQuestion(question: String, correctAnswer: String): List<CachedAnswer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(answers: List<CachedAnswer>)

}