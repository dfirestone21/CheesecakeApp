package com.example.mycheesecakes.ui.quiz

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycheesecakes.data.network.RetrofitInstance
import com.example.mycheesecakes.data.network.api.model.mappers.*
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.Quiz
import com.example.mycheesecakes.domain.model.menuitems.Dessert
import com.example.mycheesecakes.domain.model.menuitems.Drink
import com.example.mycheesecakes.domain.model.menuitems.MenuItem
import com.example.mycheesecakes.domain.model.quiz.Question
import com.example.mycheesecakes.domain.model.quiz.QuizProvider
import com.example.mycheesecakes.domain.model.quiz.QuizResult
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.lang.IllegalArgumentException

const val TAG = "QuizViewModel"

class QuizViewModel(menuItemType: Int) : ViewModel() {

    private lateinit var quiz: Quiz
    private var question: Question? = null

    // Current question
    private val _questionLiveData = MutableLiveData<Question>()
    val questionLiveData: LiveData<Question>
        get() = _questionLiveData

    private val _timeRemaining = MutableLiveData<Int>()
    val timeRemaining: LiveData<Int>
    get() = _timeRemaining

    private var quizIsStarted = false

    init {
        val menuItems = getMenuItems(menuItemType)
        Log.i(TAG,menuItems.toString())

    }

    private fun getMenuItems(menuItemType: Int): List<MenuItem> {
        return when (menuItemType) {
            MenuItem.TYPE_CHEESECAKE -> getCheesecakes()
            MenuItem.TYPE_DESSERT -> getDesserts()
            MenuItem.TYPE_DRINK -> getDrinks()
            else -> throw IllegalArgumentException("Invalid menuItemType")
        }
    }

    private fun setupQuiz(menuItems: List<MenuItem>) {
        quiz = QuizProvider().createQuiz(menuItems,QuizProvider.QUIZ_SIZE_LARGE)
        quizIsStarted = true
        nextQuestion()
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
        nextQuestion()
    }

    private fun onTimeExpired() {
        quiz.timeExpired()
        nextQuestion()
    }

    private fun onQuizComplete() {
        val quizResult = quiz.quizComplete()
        postQuizResult(quizResult)
    }

    fun fragmentOnPauseCalled() {
        quiz.pauseQuiz()
    }

    fun fragmentOnResumeCalled() {
        if (quizIsStarted) {
            quiz.resumeQuiz()
        }
    }

    fun fragmentOnStopCalled() {
        //TODO cache quiz
    }

    private fun observeTimer() {
        viewModelScope.launch {
            quiz.timer.timeFlow.collect { it
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

    private fun getCheesecakes(): List<Cheesecake> {
        var cheesecakeList = listOf<Cheesecake>()
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.airtableApi.getAllCheesecakes()
            } catch (e: IOException) {
                Log.e(TAG, "IOException")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException")
                return@launch
            }

            if (response.isSuccessful && response.body() != null) {
                val apiCheesecakesList = response.body()
                apiCheesecakesList?.cheesecakes?.let { cheesecakes ->
                   cheesecakeList = ListMapperImpl(ApiCheesecakeMapper()).mapToDomain(cheesecakes)
                    Log.i(TAG,cheesecakeList.toString())
                    setupQuiz(cheesecakeList) //TODO fix this, this call shouldn't happen here. Figure out waiting for coroutine to finish or something
                }
            }
        }
        return cheesecakeList
    }

    private fun getDesserts(): List<Dessert> {
        var dessertList = listOf<Dessert>()
        viewModelScope.launch() {
            val response = try {
                RetrofitInstance.airtableApi.getAllDesserts()
            } catch (e: IOException) {
                Log.e(TAG, "IOException")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException")
                return@launch
            }

            if (response.isSuccessful && response.body() != null) {
                val apiDessertList = response.body()
                apiDessertList?.desserts?.let { desserts ->
                    dessertList = ListMapperImpl(ApiDessertMapper()).mapToDomain(desserts)
                    setupQuiz(dessertList) //TODO Fix this, don't call it here.
                }
            }
        }
        return dessertList
    }

    private fun getDrinks(): List<Drink> {
        var drinkList = listOf<Drink>()
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.airtableApi.getAllDrinks()
            } catch (e: IOException) {
                Log.e(TAG,"IOException")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG,"HttpException")
                return@launch
            }
            if (response.isSuccessful && response.body() != null) {
                val apiDrinkList = response.body()
                apiDrinkList?.drinks?.let { drinks ->
                   drinkList = ListMapperImpl(ApiDrinkMapper()).mapToDomain(drinks)
                }
            }
        }
        return drinkList
    }

    private fun postQuizResult(quizResult: QuizResult) {
        val apiQuizResult = QuizResultToApiQuizResultMapper().mapToDomain(quizResult)
        viewModelScope.launch {
            val response = try {
                RetrofitInstance.airtableApi.postQuizResult(apiQuizResult)
            } catch (e: IOException) {
                Log.e(TAG, "IOException")
                return@launch
            } catch (e: HttpException) {
                Log.e(TAG, "HttpException")
                return@launch
            }
        }
    }
}

//TODO store all the cheesecakes, questions and answers in Room
//TODO COMMENTS!
//TODO reminder notifications
//TODO share results on social media option
//TODO if you get it wrong, allow yourself to keep trying but gray/red the incorrectly chosen answer


