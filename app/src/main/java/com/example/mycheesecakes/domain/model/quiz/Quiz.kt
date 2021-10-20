package com.example.mycheesecakes.domain.model

import com.example.mycheesecakes.domain.model.menuitems.MenuItem
import com.example.mycheesecakes.domain.model.quiz.Question
import com.example.mycheesecakes.domain.model.quiz.QuizResult
import com.example.mycheesecakes.domain.model.quiz.Score
import java.util.*

class Quiz(questions: List<Question>) {
    var correct = 0
    var incorrect = 0

    fun onQuizComplete(): QuizResult {
        return QuizResult(
            score = Score(correct,incorrect),
            date = Date()
        )
    }
}


