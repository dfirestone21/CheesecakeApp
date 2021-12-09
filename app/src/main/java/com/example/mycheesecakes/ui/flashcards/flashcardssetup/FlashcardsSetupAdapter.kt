package com.example.mycheesecakes.ui.flashcards.flashcardssetup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycheesecakes.R
import com.example.mycheesecakes.databinding.FlashcardsSetupListItemBinding
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.menuitems.*
import java.lang.IllegalArgumentException


class FlashcardsSetupAdapter(private val desserts: List<MenuItem>) : RecyclerView.Adapter<FlashcardsSetupAdapter.ViewHolder>() {
    private lateinit var binding: FlashcardsSetupListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = FlashcardsSetupListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(desserts[position])
    }

    fun getItem(position: Int): MenuItem {
        return desserts[position]
    }

    override fun getItemCount() = desserts.size

    class ViewHolder(private val binding: FlashcardsSetupListItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private lateinit var menuItem: MenuItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(menuItem: MenuItem) {
            this.menuItem = menuItem
            val context = itemView.context

            when(menuItem) {
                is Cheesecake -> {
                    binding.flashcardSetupTextview.text = context.getString(R.string.cheesecakes)
                    Glide
                        .with(context)
                        .load(menuItem.imageURL)
                        .centerCrop()
                        .placeholder(R.drawable.fresh_strawberry_cheesecake)
                        .into(binding.flashcardsSetupImageview)
                }
                is Dessert -> {
                    binding.flashcardSetupTextview.text = context.getString(R.string.desserts)
                    Glide
                        .with(context)
                        .load(menuItem.imageURL)
                        .centerCrop()
                        .placeholder(R.drawable.fresh_strawberry_cheesecake)
                        .into(binding.flashcardsSetupImageview)
                }
                is Drink -> {
                    binding.flashcardSetupTextview.text = context.getString(R.string.drinks)
                    Glide
                        .with(context)
                        .load(menuItem.imageURL)
                        .centerCrop()
                        .placeholder(R.drawable.fresh_strawberry_cheesecake)
                        .into(binding.flashcardsSetupImageview)
                }
            }
        }

        override fun onClick(v: View?) {
            when (menuItem) {
                is Cheesecake -> {
                    val action = FlashcardsSetupFragmentDirections.actionFlashcardsSetupFragmentToFlashcardsFragment(
                        MenuItem.TYPE_CHEESECAKE)
                    findNavController(itemView).navigate(action)
                }
                is Dessert -> {
                    val action = FlashcardsSetupFragmentDirections.actionFlashcardsSetupFragmentToFlashcardsFragment(
                        MenuItem.TYPE_DESSERT)
                    findNavController(itemView).navigate(action)
                }
                is Drink -> {
                    val action = FlashcardsSetupFragmentDirections.actionFlashcardsSetupFragmentToFlashcardsFragment(
                        MenuItem.TYPE_DRINK)
                    findNavController(itemView).navigate(action)
                }
                else -> throw IllegalArgumentException("Invalid argument")
            }
        }
    }
}