package com.example.mycheesecakes.app

import android.app.Application
import com.example.mycheesecakes.data.cache.QuizDatabase
import com.example.mycheesecakes.data.cache.RoomCache
import com.example.mycheesecakes.data.network.RetrofitInstance
import com.example.mycheesecakes.data.network.api.model.mappers.*
import com.example.mycheesecakes.data.repositories.MenuItemRepository
import com.example.mycheesecakes.data.repositories.QuizRepository
import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp
class App: Application() {

    companion object {
        private lateinit var instance: App

        private val database: QuizDatabase by lazy {
            QuizDatabase.buildDatabase(instance)
        }

        val menuItemRepository: MenuItemRepository by lazy {
            MenuItemRepository(
                RetrofitInstance.airtableApi,
                ApiCheesecakeMapper(),
                ApiDessertMapper(),
                ApiDrinkMapper()
            )
        }

        val quizRepository: QuizRepository by lazy {
            QuizRepository(
                RetrofitInstance.airtableApi,
                RoomCache(
                    database.QuestionAnswerDao(),
                    database.QuestionDao(),
                    database.QuizDao(),
                    database.QuizResultDao()),
                QuizResultToApiQuizResultMapper()
            )
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}