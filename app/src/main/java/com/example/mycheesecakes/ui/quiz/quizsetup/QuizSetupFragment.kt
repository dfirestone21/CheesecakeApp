package com.example.mycheesecakes.ui.quiz.quizsetup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mycheesecakes.databinding.FragmentQuizSetupBinding
import com.example.mycheesecakes.domain.model.menuitems.MenuItem
import com.example.mycheesecakes.domain.model.menuitems.menuItems

class QuizSetupFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentQuizSetupBinding

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
                val action = QuizSetupFragmentDirections.actionQuizSetupFragmentToQuizFragment(MenuItem.TYPE_CHEESECAKE)
                findNavController().navigate(action)
            }
            binding.fruitButton.id -> {
                val action = QuizSetupFragmentDirections.actionQuizSetupFragmentToQuizFragment(MenuItem.TYPE_DESSERT)
                findNavController().navigate(action)
            }
            binding.otherButton.id -> {
                val action = QuizSetupFragmentDirections.actionQuizSetupFragmentToQuizFragment(MenuItem.TYPE_DRINK)
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