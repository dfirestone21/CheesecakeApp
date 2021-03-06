package com.example.mycheesecakes.data.cache.daos

import androidx.room.*
import com.example.mycheesecakes.data.cache.model.CachedQuestion
import com.example.mycheesecakes.data.cache.model.CachedQuiz
import com.example.mycheesecakes.data.cache.model.CachedQuizAggregate
import com.example.mycheesecakes.data.cache.model.CachedQuizResult

@Dao
interface QuizDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuiz(quizAggregate: CachedQuizAggregate) {
        if (quizAggregate.isComplete) {
            insertCompletedQuizAggregate(
                quizAggregate.quiz,
                quizAggregate.questions,
                quizAggregate.quizResult!!
            )
        } else {
            insertNewQuiz(quizAggregate.quiz)
            insertQuestions(quizAggregate.questions)
        }
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompletedQuizAggregate(
        quiz: CachedQuiz,
        questions: List<CachedQuestion>,
        quizResult: CachedQuizResult
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUncompletedQuizAggregate(
        quiz: CachedQuiz,
        questions: List<CachedQuestion>
    )

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewQuiz(quiz: CachedQuiz)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestions(questions: List<CachedQuestion>)

    @Update
    suspend fun updateQuiz(quizAggregate: CachedQuizAggregate) {
        updateQuizAggregate(
            quizAggregate.quiz,
            quizAggregate.questions
        )
    }

    @Update
    suspend fun updateQuizAggregate(
        quiz: CachedQuiz,
        questions: List<CachedQuestion>
    )

    @Transaction
    @Query("SELECT * FROM quizzes WHERE NOT is_complete ORDER BY id DESC LIMIT 1")
    suspend fun getLatestUnfinishedQuiz(): CachedQuizAggregate?

    @Query("DELETE FROM quizzes")
    suspend fun removeAllQuizzes()

    @Query("DELETE FROM quizzes WHERE is_complete")
    suspend fun removeAllFinishedQuizzes()
}