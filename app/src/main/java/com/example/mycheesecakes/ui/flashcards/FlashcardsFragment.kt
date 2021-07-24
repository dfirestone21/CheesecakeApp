package com.example.mycheesecakes.ui.flashcards

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycheesecakes.R

class FlashcardsFragment : Fragment() {

    companion object {
        fun newInstance() = FlashcardsFragment()
    }

    private lateinit var viewModel: FlashcardsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_flashcards, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FlashcardsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}