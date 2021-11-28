package com.example.mycheesecakes.domain.repositories

import com.example.mycheesecakes.data.cache.model.CachedAnswer
import com.example.mycheesecakes.data.network.api.model.ApiQuizResult
import com.example.mycheesecakes.domain.model.Quiz
import com.example.mycheesecakes.domain.model.quiz.Question
import com.example.mycheesecakes.domain.model.quiz.QuizResult
import retrofit2.Response

interface QuizRepository {

    /*
    In the future, have this return Response<ApiQuizResult> so you can determine if it successfully
    posted to the database. If it didn't you'll need to cache it.
     */
    suspend fun postQuizResult(quizResult: QuizResult)

    suspend fun cacheQuizResult(quizResult: QuizResult)

    suspend fun getQuizResultById(id: Int): QuizResult

    suspend fun getAllQuizResults(): List<QuizResult>

    suspend fun getIncorrectAnswerChoices(question: String, correctAnswer: String): List<CachedAnswer>

    suspend fun cacheAnswersChoices(answers: List<CachedAnswer>)

    suspend fun cacheQuiz(quiz: Quiz)

    /*
      After each question is answered, update the question_index property to keep track of where
      the user is in the quiz. This method should also update the corresponding question using
      the questionIndex (ie quizDao.update(quiz.questions\[questionIndex])
    */
    suspend fun cacheQuizState(quiz: Quiz)

    suspend fun getUnfinishedQuiz(): Quiz?
}