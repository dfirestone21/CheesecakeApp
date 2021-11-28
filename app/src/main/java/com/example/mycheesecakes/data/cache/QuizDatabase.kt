package com.example.mycheesecakes.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mycheesecakes.data.cache.daos.*
import com.example.mycheesecakes.data.cache.model.*

const val DATABASE_VERSION = 1

@Database(entities =
            [CachedQuiz::class, CachedQuizResult::class, CachedQuestion::class, CachedAnswer::class], version = DATABASE_VERSION)
abstract class QuizDatabase: RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "QuizDatabase"
        fun buildDatabase(context: Context): QuizDatabase {
            return Room.databaseBuilder(context,
                QuizDatabase::class.java,
                DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
        }
    }

    abstract fun QuizDao(): QuizDao

    abstract fun QuestionDao(): QuestionDao

    abstract fun QuizResultDao(): QuizResultDao

    abstract fun QuestionAnswerDao(): AnswerDao
}
