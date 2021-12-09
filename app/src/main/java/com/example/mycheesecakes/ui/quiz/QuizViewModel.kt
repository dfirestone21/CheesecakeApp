package com.example.mycheesecakes.ui.quiz

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycheesecakes.app.App.Companion.menuItemRepository
import com.example.mycheesecakes.app.App.Companion.quizRepository
import com.example.mycheesecakes.data.repositories.MenuItemRepository
import com.example.mycheesecakes.data.repositories.QuizRepository
import com.example.mycheesecakes.domain.model.Quiz
import com.example.mycheesecakes.domain.model.menuitems.MenuItem
import com.example.mycheesecakes.domain.model.quiz.Question
import com.example.mycheesecakes.domain.model.quiz.QuizProvider
import com.example.mycheesecakes.domain.model.quiz.Score
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

const val TAG = "QuizViewModel"

class QuizViewModel(
    menuItemType: Int,
    quizRepository: QuizRepository,
    menuItemRepository: MenuItemRepository
) : ViewModel() {

    private lateinit var quiz: Quiz
    private var question: Question? = null

    // Current question
    private val _questionLiveData = MutableLiveData<Question>()
    val questionLiveData: LiveData<Question>
        get() = _questionLiveData

    private val _timeRemaining = MutableLiveData<Int>()
    val timeRemaining: LiveData<Int>
    get() = _timeRemaining

    private val _answerResult = MutableLiveData<String>()
    val answerResult: LiveData<String>
    get() = _answerResult

    private val _quizScore = MutableLiveData<Score>()
    val quizScore: LiveData<Score>
    get() = _quizScore

    private val _errorRetrievingData = MutableLiveData<Boolean>()
    val errorRetrievingData: LiveData<Boolean>
    get() = _errorRetrievingData

    private var quizIsStarted = false

    init {
        viewModelScope.launch {
            val cachedQuiz = quizRepository.getUnfinishedQuiz()
            if (cachedQuiz != null) {
                quiz = cachedQuiz
                beginQuiz()
            } else {
                val menuItems = getMenuItems(menuItemType)
                if (menuItems != null) {
                    setupNewQuiz(menuItems)
                } else {
                    errorRetrievingItems()
                }
            }
        }
    }

    private suspend fun getMenuItems(menuItemType: Int): List<MenuItem>? {
        return when (menuItemType) {
            MenuItem.TYPE_CHEESECAKE -> menuItemRepository.getAllCheesecakes()
            MenuItem.TYPE_DESSERT -> menuItemRepository.getAllDesserts()
            MenuItem.TYPE_DRINK -> menuItemRepository.getAllDrinks()
            else -> throw IllegalArgumentException("Invalid menuItemType")
        }
    }

    private fun beginQuiz() {
        quizIsStarted = true
        nextQuestion()
    }

    private fun setupNewQuiz(menuItems: List<MenuItem>, quizSize: Int = QuizProvider.QUIZ_SIZE_MEDIUM) {
        quiz = QuizProvider().createQuiz(menuItems,quizSize)
        //viewModelScope.launch { quizRepository.cacheQuiz(quiz) }
        beginQuiz()
    }

    private fun nextQuestion() {
        question = quiz.getNextQuestion()
        if (question == null) {
            onQuizComplete()
        } else {
            question?.let {
                _questionLiveData.value = it
                observeTimer()
            }
        }
    }

    fun onQuestionAnswered(answer: String) {
      quiz.onQuestionAnswered(answer)
      _answerResult.value = quiz.answerResponse()
      //viewModelScope.launch { quizRepository.cacheQuizState(quiz) }
      nextQuestion()
    }

    private fun onTimeExpired() {
        quiz.timeExpired()
        nextQuestion()
    }

    private fun onQuizComplete() {
        val quizResult = quiz.quizComplete()
        viewModelScope.launch { quizRepository.postQuizResult(quizResult) }
        _quizScore.value = quizResult.score
    }


    fun fragmentOnPauseCalled() {
        if (quizIsStarted) {
            quiz.pauseQuiz()
        }
    }

    fun fragmentOnResumeCalled() {
        if (quizIsStarted) {
            quiz.resumeQuiz()
        }
    }

    fun fragmentOnStopCalled() {
        //viewModelScope.launch { quizRepository.cacheQuizState(quiz) }
    }

    private fun errorRetrievingItems() {
        _errorRetrievingData.value = true
    }

    private fun observeTimer() {
        viewModelScope.launch {
            quiz.timer.timeFlow.collect {
                _timeRemaining.value = it
                if (it == 0) {
                    onTimeExpired()
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
        quiz.quizComplete()
    }
}