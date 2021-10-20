package com.example.mycheesecakes.domain.model.quiz

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.mycheesecakes.domain.model.Quiz
import com.example.mycheesecakes.domain.model.quiz.menuItems.QuizMenuItem

class QuizProvider {

    private val questionsToAnswersMap = hashMapOf<String, MutableList<String>>()
    private lateinit var menuItems: List<QuizMenuItem>

    @RequiresApi(Build.VERSION_CODES.N)
    fun createQuiz(menuItems: List<QuizMenuItem>): Quiz {
        this.menuItems = menuItems
        generateQuestionsAndAnswersMap(menuItems)

        val questions = generateQuestions()
        return Quiz(questions)
    }



    @RequiresApi(Build.VERSION_CODES.N)
    private fun generateQuestions(): List<Question> {
        val questionList = mutableListOf<Question>()
        menuItems.forEach { menuItem ->
            menuItem.propertyMap.forEach { (question, correctAnswer) ->
                val answers = mutableSetOf<String>()
                while (answers.size != 3) {
                    answers.add(questionsToAnswersMap[question]!!.random())
                }

                val question = Question(
                    itemName = menuItem.name,
                    question = question,
                    answers = answers.toList(),
                    correctAnswer = correctAnswer,
                    itemImageURL = menuItem.imageURL)

                questionList.add(question)
            }
        }
        return questionList
    }


    @RequiresApi(Build.VERSION_CODES.N)
    private fun generateQuestionsAndAnswersMap(menuItems: List<QuizMenuItem>) {
        menuItems.forEach { menuItem ->
            menuItem.propertyMap.forEach { (key, value) ->
                questionsToAnswersMap[key]?.add(value)
            }
        }
    }
}