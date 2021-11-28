package com.example.mycheesecakes.data.cache

import com.example.mycheesecakes.data.cache.daos.AnswerDao
import com.example.mycheesecakes.data.cache.daos.QuestionDao
import com.example.mycheesecakes.data.cache.daos.QuizDao
import com.example.mycheesecakes.data.cache.daos.QuizResultDao
import com.example.mycheesecakes.data.cache.model.CachedAnswer
import com.example.mycheesecakes.data.cache.model.CachedQuizAggregate
import com.example.mycheesecakes.data.cache.model.CachedQuizResult

class RoomCache(
    private val answerDao: AnswerDao,
    private val questionDao: QuestionDao,
    private val quizDao: QuizDao,
    private val quizResultDao: QuizResultDao
) : Cache {

    override suspend fun storeQuizResult(quizResult: CachedQuizResult) {
        quizResultDao.insert(quizResult)
    }

    override suspend fun getIncorrectAnswerChoices(question: String, correctAnswer: String): List<CachedAnswer> {
        return answerDao.getIncorrectAnswersForQuestion(question,correctAnswer)
    }

    override suspend fun storeAnswers(answers: List<CachedAnswer>) {
        answerDao.insert(answers)
    }

    override suspend fun getQuizResultById(id: Int): CachedQuizResult {
        return quizResultDao.getById(id)
    }

    override suspend fun getAllQuizResults(): List<CachedQuizResult> {
        return quizResultDao.getAllQuizResults()
    }

    override suspend fun storeQuiz(quizAggregate: CachedQuizAggregate) {
        quizDao.insertQuiz(quizAggregate)
    }

    override suspend fun storeQuizState(quizAggregate: CachedQuizAggregate) {
        quizDao.updateQuiz(quizAggregate)
    }

    override suspend fun getUnfinishedQuiz(): CachedQuizAggregate? {
        return quizDao.getLatestUnfinishedQuiz()
    }

}