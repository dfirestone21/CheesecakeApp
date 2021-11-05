package com.example.mycheesecakes.data.network.api.model.mappers

import com.example.mycheesecakes.data.network.api.model.ApiQuizResult
import com.example.mycheesecakes.domain.model.quiz.QuizResult

class QuizResultToApiQuizResultMapper: ApiMapper<QuizResult,ApiQuizResult> {
    override fun mapToDomain(apiEntity: QuizResult): ApiQuizResult {
        return ApiQuizResult(
            fields = ApiQuizResult.Fields(
                correct = apiEntity.score.correct,
                incorrect = apiEntity.score.incorrect,
                date = apiEntity.date
            )
        )
    }
}