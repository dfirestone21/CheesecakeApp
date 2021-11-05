package com.example.mycheesecakes.domain.model.menuitems.util

fun List<String>.toStringWithoutBrackets(): String {
    return toString().replace("[","").replace("]","")
}