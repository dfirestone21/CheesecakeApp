package com.example.mycheesecakes.app

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}