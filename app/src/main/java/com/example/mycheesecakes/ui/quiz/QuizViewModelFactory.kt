package com.example.mycheesecakes.ui.quiz

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class QuizViewModelFactory(val cheesecakeType: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
            return QuizViewModel(cheesecakeType) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}