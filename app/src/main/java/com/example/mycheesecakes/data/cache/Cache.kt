package com.example.mycheesecakes.data.cache

import com.example.mycheesecakes.data.cache.model.*

interface Cache {
// Works with all of the Cache models
// Has references to all the daos
// Doesn't do the mapping, that's what the repository does
// Having the caching interface prevents the repository from being bloated,
// so it just calls api methods and cache methods
    suspend fun storeQuizResult(quizResult: CachedQuizResult)

    suspend fun getIncorrectAnswerChoices(question: String, correctAnswer: String): List<CachedAnswer>?

    suspend fun getQuizResultById(id: Int): CachedQuizResult?

    suspend fun getAllQuizResults(): List<CachedQuizResult>

    suspend fun storeAnswers(answers: List<CachedAnswer>)

    suspend fun storeQuiz(quizAggregate: CachedQuizAggregate)

    suspend fun storeQuizState(quizAggregate: CachedQuizAggregate)

    suspend fun getUnfinishedQuiz(): CachedQuizAggregate?

    suspend fun removeAllQuizzes()

    suspend fun storeNewQuiz(quiz: CachedQuiz)

    suspend fun storeQuestions(questions: List<CachedQuestion>)
}