package com.example.mycheesecakes.data.network.api.model.mappers

import com.example.mycheesecakes.data.network.api.model.ApiQuizResult
import com.example.mycheesecakes.domain.model.Quiz
import com.example.mycheesecakes.domain.model.quiz.QuizResult
import com.example.mycheesecakes.domain.model.quiz.Score

class ApiQuizResultMapper: ApiMapper<ApiQuizResult,QuizResult> {
    override fun mapToDomain(apiEntity: ApiQuizResult): QuizResult {
        return QuizResult(
            score = Score(
                correct = apiEntity?.fields?.correct ?: 0,
                incorrect = apiEntity?.fields?.incorrect ?: 0),
            date = apiEntity?.fields?.date ?: 0,
            id = apiEntity?.fields?.id ?: 0)
    }
}