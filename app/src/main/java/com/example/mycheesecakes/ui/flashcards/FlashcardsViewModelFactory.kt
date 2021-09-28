package com.example.mycheesecakes.ui.flashcards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FlashcardsViewModelFactory(private val menuItemType: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FlashcardsViewModel(menuItemType) as T
    }
}