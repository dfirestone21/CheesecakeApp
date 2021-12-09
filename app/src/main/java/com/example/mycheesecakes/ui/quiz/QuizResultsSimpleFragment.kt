package com.example.mycheesecakes.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mycheesecakes.databinding.FragmentQuizResultSimpleBinding

class QuizResultsSimpleFragment: Fragment() {

    private lateinit var binding: FragmentQuizResultSimpleBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizResultSimpleBinding.inflate(inflater)

        val arguments = QuizResultsSimpleFragmentArgs.fromBundle(requireArguments())
        binding.quizResultSimpNumCorrectTextview.text = arguments.numCorrect.toString()
        binding.quizResultSimpTotalTextview.text = arguments.total.toString()
        return binding.root
    }
}