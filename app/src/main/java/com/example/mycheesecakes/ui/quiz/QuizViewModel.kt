package com.example.mycheesecakes.ui.quiz

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycheesecakes.domain.model.Category
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.allCheesecakeList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
const val TAG = "QuizViewModel"

class QuizViewModel(private val cheesecakeType: Int) : ViewModel() {

    // List of cheesecakes for quiz, chosen based on cheesecakeType parameter
    private lateinit var cheesecakeList: List<Cheesecake>

    // Cheesecake used for current quiz question
    private val _cheesecakeLiveData = MutableLiveData<Cheesecake>()
    val cheesecakeLiveData: LiveData<Cheesecake>
        get() = _cheesecakeLiveData

    // Current question
    private val _questionLiveData = MutableLiveData<String>()
    val questionLiveData: LiveData<String>
        get() = _questionLiveData

    // List of current answer choices
    private val _answersLiveData = MutableLiveData<List<String>>()
    val answersLiveData: LiveData<List<String>>
        get() = _answersLiveData

    // Current correct answer
    private val _correctAnswerLiveData = MutableLiveData<Boolean?>()
    val correctAnswerLiveData: LiveData<Boolean?>
        get() = _correctAnswerLiveData

    // 30 second timer for each question
    private val _questionTimerLiveData = MutableLiveData<Int>()
    val questionTimerLiveData: LiveData<Int>
        get() = _questionTimerLiveData

    private inner class QuestionTimer(var totalTime: Long = 30000, tickTime: Long = 1000) : CountDownTimer(totalTime, tickTime) {
        //var timeRemaining: Long = totalTime

        override fun onTick(millisUntilFinished: Long) {
            totalTime = millisUntilFinished
            _questionTimerLiveData.value = (millisUntilFinished/1000).toInt()
        }

        override fun onFinish() {
            onTimeExpired()
        }
    }

    var correctAnswer = ""

    private val questions = HashMap<String,List<String>>()

    private var cheesecakeQuestions = mutableListOf<String>()

    private val answerCategories = listOf("Cheesecake","Crust","Nuts","Dollops","Topping","Presentation")

    private var questionIndex = 0

    private var questionTimer: QuestionTimer? = null

    var cheesecake: Cheesecake? = null

    init {
        _correctAnswerLiveData.value = null

        getCheesecakes()

        for (item in answerCategories) {
            viewModelScope.launch { generateQuestions(item) }
        }

        nextQuestion()
    }

    private fun getChocolateCheesecakes(): List<Cheesecake> {
        Log.i(TAG,"getChocolateCheesecakes called")
        val chocolateCheesecakes = mutableListOf<Cheesecake>()
        allCheesecakeList.forEach {
            if (it.categories.contains(Category.CHOCOLATE)) {
                chocolateCheesecakes.add(it)
            }
        }
        chocolateCheesecakes.shuffle()
        return chocolateCheesecakes
    }

    private fun getFruitCheesecakes(): List<Cheesecake> {
        Log.i(TAG,"getFruitCheesecakes called")
        val fruitCheesecakes = mutableListOf<Cheesecake>()

        allCheesecakeList.forEach {
            if (it.categories.contains(Category.FRUIT)) {
                fruitCheesecakes.add(it)
            }
        }
        fruitCheesecakes.shuffle()
        return fruitCheesecakes
    }

    private fun getOtherCheesecakes(): List<Cheesecake> {
        Log.i(TAG,"getOtherCheesecakes called")
        val otherCheesecakes = mutableListOf<Cheesecake>()

        allCheesecakeList.forEach {
            if (!it.categories.contains(Category.CHOCOLATE) &&
                    !it.categories.contains(Category.FRUIT)) {
                otherCheesecakes.add(it)
            }
        }
        otherCheesecakes.shuffle()


        return otherCheesecakes
    }

    private fun getPresentationList(): List<Cheesecake> {
        val presentationList = mutableListOf<Cheesecake>()

        allCheesecakeList.forEach {
            if (it.presentation != "Whip") {
                presentationList.add(it)
            }
        }

        presentationList.shuffle()
        return presentationList
    }

    private fun getCheesecakes() {
        Log.i(TAG,"getCheesecakes called")
        cheesecakeList = when (cheesecakeType) {
            0 -> {
                getChocolateCheesecakes()
            }
            1 -> {
                getFruitCheesecakes()
            }
            2 -> {
                getOtherCheesecakes()
            }
            else -> getPresentationList()
        }
    }

    private fun nextQuestion() {
        Log.i(TAG,"nextQuestion called")
        var question = getNewQuestion()
        if (question == null) {
            cheesecake = getNewCheesecake(questionIndex++) ?: return
            question = getNewQuestion()
        }


        correctAnswer = getCorrectAnswer(question!!, cheesecake!!)
        val answerList = getAnswerList(question)
        _questionLiveData.value = question!!
        _answersLiveData.value = answerList
        _correctAnswerLiveData.value = null
        setupTimer()

    }

    fun onQuestionAnswered(answer: String) {
        Log.i(TAG,"onQuestionAnswered called")
        questionTimer?.cancel()
        checkIfCorrect(answer)
        nextQuestion()
    }

    private fun onTimeExpired() {
        Log.i(TAG,"onTimeExpired called")
        onQuestionAnswered("Incorrect")
    }

    private fun checkIfCorrect(answer: String): Boolean {
        Log.i(TAG,"checkIfCorrect called")
        return if (answer == correctAnswer) {
            _correctAnswerLiveData.value = true
            true
        } else {
            _correctAnswerLiveData.value = false
            false
        }
    }

    private suspend fun generateQuestions(question: String) {
        Log.i(TAG,"generateQuestions called")
        withContext(Dispatchers.IO) {
            val answers = mutableListOf<String>()

            when (question) {
                "Cheesecake" -> {
                    cheesecakeList.forEach {
                        if (!answers.contains(it.cheesecake)) {
                            answers.add(it.cheesecake)
                        }
                    }
                    questions[question] = answers
                }
                "Crust" -> {
                    cheesecakeList.forEach {
                        if (!answers.contains(it.crust)) {
                            answers.add(it.crust)
                        }
                    }
                    questions[question] = answers
                }
                "Nuts" -> {
                    cheesecakeList.forEach {
                        if (!answers.contains(it.nuts)) {
                            answers.add(it.nuts.toString())
                        }
                    }
                    answers.apply {
                        add("Almonds")
                        add("Pistachio")
                    }
                    questions[question] = answers
                }
                "Dollops" -> {
                    cheesecakeList.forEach {
                        if (!answers.contains(it.dollops)) {
                            answers.add(it.dollops)
                        }
                    }
                    answers.add("None")
                    answers.add("Three")
                    questions[question] = answers
                }
                "Topping" -> {
                    cheesecakeList.forEach {
                        if (!answers.contains(it.topping)) {
                            answers.add(it.topping)
                        }
                    }
                    questions[question] = answers
                }
                "Presentation" -> {
                    cheesecakeList.forEach {
                        if (!answers.contains(it.presentation)) {
                            answers.add(it.presentation)
                        }
                    }
                    questions[question] = answers
                }
            }

        }
    }

    private fun getCorrectAnswer(category: String, cheesecake: Cheesecake): String {
        Log.i(TAG,"getCorrectAnswer called")
        return when (category) {
            "Cheesecake" -> cheesecake.cheesecake
            "Crust" -> cheesecake.crust
            "Nuts" -> cheesecake.nuts.toString()
            "Dollops" -> cheesecake.dollops
            "Topping" -> cheesecake.topping
            "Presentation" -> cheesecake.presentation
            else -> "Error"
        }
    }

    private fun getNewCheesecake(index: Int): Cheesecake? {
        Log.i(TAG,"getNewCheesecake called")
        if (index > cheesecakeList.lastIndex) {
            onQuizComplete()
            return null
        }

        // New list to be used as a queue, where each question is dequeued after being asked
        cheesecakeQuestions = answerCategories.toMutableList()
        cheesecakeQuestions.shuffle()

        val cheesecake = cheesecakeList[index]
        _cheesecakeLiveData.value = cheesecake
        return cheesecake

    }

    private fun getNewQuestion(): String? {
        Log.i(TAG,"getNewQuestion called")
        return if (cheesecakeQuestions.isEmpty()) {
            null
        } else cheesecakeQuestions.removeFirst()
    }

    private fun getAnswerList(question: String): List<String> {
        Log.i(TAG,"getAnswerList called")
        val answerList = mutableListOf<String>()
        answerList.add(correctAnswer)

        while (answerList.size < 4) {
            val answer = questions[question]!!.random()
            if (!answerList.contains(answer)) {
                answerList.add(answer)
                Log.i(TAG, "$answer added to answerList")
                Log.i(TAG,"answerList: $answerList")
            }
        }
        answerList.shuffle()
        return answerList
    }

    private fun setupTimer(timeRemaining: Long = 30000) {
        Log.i(TAG,"setupTimer called")
        questionTimer?.cancel()
        questionTimer = QuestionTimer(totalTime = timeRemaining)
        questionTimer?.start()
    }

    private fun onQuizComplete() {
        Log.i(TAG,"onQuizComplete called")

    }

    fun fragmentOnPauseCalled() {
        Log.i(TAG,"fragmentOnPauseCalled")
        questionTimer?.cancel()
    }

    fun fragmentOnResumeCalled() {
        Log.i(TAG,"fragmentOnResume called")
        questionTimer?.totalTime?.let { setupTimer(it) }
    }



    override fun onCleared() {
        Log.i(TAG,"onCleared called")
        super.onCleared()
        viewModelScope.cancel()
    }
}

//TODO GameController
//TODO retrieve cheesecake list with coroutines
//TODO store all the cheesecakes, questions and answers in Room
//TODO COMMENTS!
//TODO finish button, and review showing what questions you got wrong
//TODO reminder notifications
//TODO share results on social media option
//TODO if you get it wrong, allow yourself to keep trying but gray/red the incorrectly chosen answer
//TODO have the viewmodel as generic as possible so you can have different topics like drinks


