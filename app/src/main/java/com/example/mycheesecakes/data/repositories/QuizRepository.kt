package com.example.mycheesecakes.data.repositories

import android.util.Log
import com.example.mycheesecakes.data.cache.RoomCache
import com.example.mycheesecakes.data.cache.daos.*
import com.example.mycheesecakes.data.cache.model.*
import com.example.mycheesecakes.data.network.api.AirtableApi
import com.example.mycheesecakes.data.network.api.model.ApiQuizResult
import com.example.mycheesecakes.data.network.api.model.mappers.QuizResultToApiQuizResultMapper
import com.example.mycheesecakes.domain.model.Quiz
import com.example.mycheesecakes.domain.model.quiz.Question
import com.example.mycheesecakes.domain.model.quiz.QuizResult
import com.example.mycheesecakes.domain.repositories.QuizRepository
import com.example.mycheesecakes.ui.quiz.TAG
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

class QuizRepository(
    private val api: AirtableApi,
    private val cache: RoomCache,
    private val apiQuizResultMapper: QuizResultToApiQuizResultMapper
) : QuizRepository {

    /**
     * Posts quiz result to remote database if network is available.
     *
     */
    override suspend fun postQuizResult(quizResult: QuizResult) {
        val apiQuizResult = apiQuizResultMapper.mapToDomain(quizResult)
        val response = try {
            api.postQuizResult(apiQuizResult)
        } catch (e: IOException) {
            Log.e(TAG, "IOException")
            return
        } catch (e: HttpException) {
            Log.e(TAG, "HttpException")
            return
        }
    }

    /*
     Used to store QuizResult if no network is available
     */
    override suspend fun cacheQuizResult(quizResult: QuizResult) {
        val cachedQuizResult = CachedQuizResult.fromDomain(quizResult)
        cache.storeQuizResult(cachedQuizResult)
    }

    /**
     * Retrieves incorrect answer choices for multiple choice question.
     */
    override suspend fun getIncorrectAnswerChoices(question: String, correctAnswer: String): List<CachedAnswer> {
       return cache.getIncorrectAnswerChoices(question,correctAnswer)
    }

    override suspend fun getQuizResultById(id: Int): QuizResult {
        val cachedQuizResult = cache.getQuizResultById(id)
        return cachedQuizResult.toDomain()
    }

    override suspend fun getAllQuizResults(): List<QuizResult> {
        val cachedQuizResults = cache.getAllQuizResults()
        return cachedQuizResults.map { it.toDomain() }
    }

    override suspend fun cacheAnswersChoices(answers: List<CachedAnswer>) {
        cache.storeAnswers(answers)
    }

    override suspend fun cacheQuiz(quiz: Quiz) {
        val quizAggregate = quiz.getCachedQuizAggregate()
        cache.storeQuiz(quizAggregate)
    }

    override suspend fun getUnfinishedQuiz(): Quiz? {
        val cachedQuiz = cache.getUnfinishedQuiz()
        cachedQuiz?.let {
            return cachedQuiz.toDomain()
        }
        return null
    }

    override suspend fun cacheQuizState(quiz: Quiz) {
        val quizAggregate = quiz.getCachedQuizAggregate()
        cache.storeQuizState(quizAggregate)
    }

}