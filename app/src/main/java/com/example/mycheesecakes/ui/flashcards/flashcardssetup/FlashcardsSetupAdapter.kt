package com.example.mycheesecakes.ui.flashcards.flashcardssetup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycheesecakes.R
import com.example.mycheesecakes.databinding.FlashcardsSetupListItemBinding
import com.example.mycheesecakes.model.Cheesecake
import com.example.mycheesecakes.model.menuitems.MenuItem
import com.example.mycheesecakes.model.menuitems.Dessert
import com.example.mycheesecakes.model.menuitems.Drink


class FlashcardsSetupAdapter(private val desserts: List<MenuItem>) : RecyclerView.Adapter<FlashcardsSetupAdapter.ViewHolder>() {
    private lateinit var binding: FlashcardsSetupListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlashcardsSetupAdapter.ViewHolder {
        binding = FlashcardsSetupListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FlashcardsSetupAdapter.ViewHolder, position: Int) {
        holder.bind(desserts[position])
    }

    override fun getItemCount() = desserts.size

    class ViewHolder(private val binding: FlashcardsSetupListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var menuItem: MenuItem

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
    }
}