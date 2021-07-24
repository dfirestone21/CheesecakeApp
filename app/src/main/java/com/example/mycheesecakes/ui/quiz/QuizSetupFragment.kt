package com.example.mycheesecakes.ui.quiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mycheesecakes.databinding.FragmentQuizSetupBinding
import com.example.mycheesecakes.ui.quiz.QuizSetupFragmentDirections
import java.util.*


class QuizSetupFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentQuizSetupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizSetupBinding.inflate(inflater)

        setupButtons()

        return binding.root
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            binding.chocolateButton.id -> {
                val action = QuizSetupFragmentDirections.actionQuizSetupFragmentToQuizFragment(0)
                findNavController().navigate(action)
            }
            binding.fruitButton.id -> {
                val action = QuizSetupFragmentDirections.actionQuizSetupFragmentToQuizFragment(1)
                findNavController().navigate(action)
            }
            binding.otherButton.id -> {
                val action = QuizSetupFragmentDirections.actionQuizSetupFragmentToQuizFragment(2)
                findNavController().navigate(action)
            }
            binding.presentationButton.id -> {
                val action = QuizSetupFragmentDirections.actionQuizSetupFragmentToQuizFragment(3)
                findNavController().navigate(action)
            }
            else -> return
        }
    }

    private fun setupButtons() {
        binding.chocolateButton.setOnClickListener(this)
        binding.fruitButton.setOnClickListener(this)
        binding.otherButton.setOnClickListener(this)
        binding.presentationButton.setOnClickListener(this)
    }
}