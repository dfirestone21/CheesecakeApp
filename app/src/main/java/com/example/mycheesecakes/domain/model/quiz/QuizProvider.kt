package com.example.mycheesecakes.domain.model.quiz

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.lifecycle.viewModelScope
import com.example.mycheesecakes.data.network.RetrofitInstance
import com.example.mycheesecakes.data.network.api.ApiConstants
import com.example.mycheesecakes.data.network.api.model.mappers.ApiCheesecakeMapper
import com.example.mycheesecakes.data.network.api.model.mappers.ListMapperImpl
import com.example.mycheesecakes.domain.model.Quiz
import com.example.mycheesecakes.domain.model.menuitems.MenuItem
import com.example.mycheesecakes.domain.model.quiz.menuItems.QuizMenuItem
import com.example.mycheesecakes.domain.model.quiz.menuItems.QuizMenuItemMapper
import com.example.mycheesecakes.ui.quiz.TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import retrofit2.HttpException
import java.io.IOException

//TODO pass in menuItem type and amount, and retrieve them here.
// That way you only get as many as you need

class QuizProvider {

    private val TAG = "QuizProvider"

    companion object {
        const val QUIZ_SIZE_SMALL = 10
        const val QUIZ_SIZE_MEDIUM = 20
        const val QUIZ_SIZE_LARGE = 30
    }

    //TODO store the questions and answers in Room and retrieve them from there
    /**
     * The map containing questions to all possible answers, used for multiple choice.
     */
    private val questionsToAnswersMap = hashMapOf<String, MutableSet<String>>()

    /**
     * The QuizMenuItems list which was mapped from MenuItems list
     */
    private val quizMenuItems: MutableList<QuizMenuItem> = mutableListOf()

    fun createQuiz(menuItems: List<MenuItem>, quizSize: Int = QUIZ_SIZE_MEDIUM): Quiz {
        Log.d(TAG,menuItems.toString())
        // Maps MenuItem to QuizMenuItem to access the propertyMap for quiz questions
        val mapper = QuizMenuItemMapper()
        menuItems.forEach {
            quizMenuItems.add(mapper(it))
        }
        quizMenuItems.shuffle()

        generateQuestionsAndAnswersMap(quizMenuItems)

        val questions = generateQuestions(quizSize)
        return Quiz(questions)
    }

    private fun generateQuestions(quizSize: Int): MutableList<Question> {
        val questionList = mutableListOf<Question>()
            // Questions are created from each menuItem that was passed in
            for (menuItem in quizMenuItems) {
                // A question is created from each property of the menuItem's propertyMap
                for ((question, correctAnswer) in menuItem.questionMap) {
                    if (questionList.size >= quizSize) {
                        return questionList
                    }
                    val answers = mutableSetOf(correctAnswer)
                    while (answers.size < 4) {
                        answers.add(questionsToAnswersMap[question]!!.random())
                    }
                    val question = Question(
                        itemName = menuItem.name,
                        question = question,
                        answers = answers.toList().shuffled(),
                        correctAnswer = correctAnswer,
                        itemImageURL = menuItem.imageURL)

                    questionList.add(question)
                }
            }
        return questionList
    }


    private fun generateQuestionsAndAnswersMap(menuItems: List<QuizMenuItem>) {
        //initialize map
        menuItems.first().questionMap.forEach { (key, _) ->
            questionsToAnswersMap[key] = mutableSetOf()
            if (key == "Dollops") { // Not enough Dollops for multiple choice
                questionsToAnswersMap[key] = mutableSetOf("None","Three")
            }
        }
        menuItems.forEach { menuItem ->
            menuItem.questionMap.forEach { (key, value) ->
                questionsToAnswersMap[key]?.add(value)
            }
        }
        questionsToAnswersMap.forEach { (_, value) ->
            value.toSet().toList()
        }
    }

    /*
    private fun getAnswers(question: String): List<String> {
        runBlocking {
            launch {
                val response = try {
                    RetrofitInstance.airtableApi.getAnswers(ApiConstants.CHEESECAKES_ENDPOINT,listOf(question))
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
                        setupQuiz(cheesecakeList)
                    }
                }
        }

    }

     */
}