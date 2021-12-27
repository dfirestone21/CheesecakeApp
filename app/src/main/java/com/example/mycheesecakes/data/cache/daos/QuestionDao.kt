package com.example.mycheesecakes.data.cache.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.example.mycheesecakes.data.cache.model.CachedQuestion

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(questions: List<CachedQuestion>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(vararg question: CachedQuestion)



}