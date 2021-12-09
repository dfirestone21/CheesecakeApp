package com.example.mycheesecakes.data.cache.model

/**
 * Used to view correct/incorrect questions in Quiz Results page.
 */
data class CachedQuizResultWithQuestions(
    val quizResult: CachedQuizResult,
    val questions: List<CachedQuestion>
)
