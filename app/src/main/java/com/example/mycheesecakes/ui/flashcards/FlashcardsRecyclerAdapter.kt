package com.example.mycheesecakes.ui.flashcards

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycheesecakes.R
import com.example.mycheesecakes.databinding.FlashcardsListItemBinding
import com.example.mycheesecakes.model.menuitems.MenuItem

const val TAG = "FlashcardsAdapter"


class FlashcardsAdapter(private val menuItems: List<MenuItem>, private val clickListener: AdapterClickListener) : RecyclerView.Adapter<FlashcardsAdapter.ViewHolder>() {

    private lateinit var binding: FlashcardsListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG,"onCreateViewHolder called")
        binding = FlashcardsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i(TAG,"onBindViewHolder called on position $position")
        holder.bind(menuItems[position])
        clickListener.onClick(menuItems[position])
    }

    override fun getItemCount() = menuItems.size


    class ViewHolder(private val binding: FlashcardsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private lateinit var menuItem: MenuItem

        fun bind(menuItem: MenuItem) {
            Log.i(TAG,"ViewHolder.bind() called")
            this.menuItem = menuItem
            val context = itemView.context
            binding.flashcardListitemTextview.text = menuItem.name
            Glide
                .with(context)
                .load(menuItem.imageURL)
                .centerCrop()
                .placeholder(R.drawable.fresh_strawberry_cheesecake)
                .into(binding.cardCheesecakeImageview)
        }
    }
}

interface AdapterClickListener{
    fun onClick(menuItem: MenuItem)
}