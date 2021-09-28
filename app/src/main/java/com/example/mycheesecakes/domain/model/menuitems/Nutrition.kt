package com.example.mycheesecakes.domain.model.menuitems

data class Nutrition(
    val calories: Int,
    val fatCalories: Int,
    val totalFat: Int,
    val saturatedFat: Int,
    val transFat: Int,
    val cholesterol: Int,
    val sodium: Int,
    val fiber: Int,
    val sugar: Int,
    val protein: Int,
    val caloriesPerServing: Int
)
