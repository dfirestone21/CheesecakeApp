package com.example.mycheesecakes.ui.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mycheesecakes.R
import com.example.mycheesecakes.databinding.FragmentQuizResultsBinding

private lateinit var binding: FragmentQuizResultsBinding

class QuizResultsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentQuizResultsBinding.inflate(inflater)
        return binding.root
    }
}