package com.example.mycheesecakes.data.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycheesecakes.data.cache.model.CachedQuizResult
import retrofit2.http.GET

@Dao
interface QuizResultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(quizResult: CachedQuizResult)

    @Query("SELECT * FROM quiz_results WHERE id = :id")
    suspend fun getById(id: Int): CachedQuizResult

    @Query("SELECT * FROM quiz_results ORDER BY quiz_id DESC")
    suspend fun getAllQuizResults(): List<CachedQuizResult>
}