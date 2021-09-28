package com.example.mycheesecakes.ui.flashcards

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycheesecakes.R
import com.example.mycheesecakes.databinding.FragmentFlashcardBackBinding
import com.example.mycheesecakes.databinding.FragmentFlashcardsBinding


class FlashcardBackFragment : Fragment() {
    private lateinit var binding: FragmentFlashcardBackBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_flashcard_back, container, false)
    }

}