package com.example.mycheesecakes.domain.model.quiz

data class Score(
    val correct: Int,
    val incorrect: Int,
) {
    /**
    * Result of correct/incorrect. Used as a percentage value.
     **/
    val score: Int
    get() = ((correct.toDouble()/(correct+incorrect))*100).toInt()

    val grade: String
    get() = when (score) {
        in 97..100 -> "A+"
        in 94..96 -> "A"
        in 90..93 -> "A-"
        in 87..89 -> "B+"
        in 84..86 -> "B"
        in 80..83 -> "B-"
        in 77..79 -> "C+"
        in 74..76 -> "C"
        in 70..73 -> "C-"
        in 67..69 -> "D+"
        in 64..66 -> "D"
        in 60..63 -> "D-"
        else -> "F"
    }
}
