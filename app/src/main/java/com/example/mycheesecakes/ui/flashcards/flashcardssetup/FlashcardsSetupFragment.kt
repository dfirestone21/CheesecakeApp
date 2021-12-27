package com.example.mycheesecakes.ui.flashcards.flashcardssetup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycheesecakes.databinding.FragmentFlashcardsSetupBinding
import com.example.mycheesecakes.domain.model.menuitems.menuItems


class FlashcardsSetupFragment : Fragment() {

    private lateinit var binding: FragmentFlashcardsSetupBinding
    private val adapter = FlashcardsSetupAdapter(menuItems)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFlashcardsSetupBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.flashcardsSetupRecyclerview.layoutManager = LinearLayoutManager(activity)
        binding.flashcardsSetupRecyclerview.adapter = adapter
    }
}