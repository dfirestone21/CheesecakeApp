package com.example.mycheesecakes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mycheesecakes.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

// TODO Get the data from AirTables API
// TODO After flashcards screens are done, do the post-quiz analysis screen
// TODO Make the flashcards screen the default screen, and have a bottom navigation menu that can go to Quiz and Profile
// TODO QuizController and FlashcardsController that create the quiz/flashcards and pass it to the viewmodel. They have more features available
// TODO Profile: Have your basic profile with picture, also track your time studying flashcards and quiz scores.
// TODO Achievements, also part of profile. ie 100% Chocolate Cheesecakes score, studied flashcards for 1 hour, etc.
// TODO Make a cleaning checklist
// TODO Cheesecake picker for customers. Choose things you like: Cake, chocolate, fruit, caramel, etc