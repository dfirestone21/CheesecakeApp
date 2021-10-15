package com.example.mycheesecakes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mycheesecakes.databinding.FragmentMainMenuBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MainMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainMenuFragment : Fragment() {

    private lateinit var binding: FragmentMainMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainMenuBinding.inflate(inflater,container,false)

        binding.takeQuizButton.setOnClickListener {
            val action = MainMenuFragmentDirections.actionMainMenuFragmentToQuizSetupFragment()
            findNavController().navigate(action)
        }

        binding.studyFlashcardsButton.setOnClickListener{
            val action = MainMenuFragmentDirections.actionMainMenuFragmentToFlashcardsSetupFragment()
            findNavController().navigate(action)
        }
        return binding.root
    }

    //TODO move the button click listeners into one method



}