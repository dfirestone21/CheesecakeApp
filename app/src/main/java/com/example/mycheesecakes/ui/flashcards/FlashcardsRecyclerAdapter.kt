package com.example.mycheesecakes.ui.flashcards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mycheesecakes.R
import com.example.mycheesecakes.databinding.FlashcardsListItemBinding
import com.example.mycheesecakes.domain.model.menuitems.MenuItem

const val TAG = "FlashcardsAdapter"


class FlashcardsRecyclerAdapter(private val menuItems: List<MenuItem>, private val clickListener: AdapterClickListener) : RecyclerView.Adapter<FlashcardsRecyclerAdapter.ViewHolder>() {

    private lateinit var binding: FlashcardsListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = FlashcardsListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding, clickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(menuItems[position])
    }

    override fun getItemCount() = menuItems.size


    class ViewHolder(private val binding: FlashcardsListItemBinding, private val clickListener: AdapterClickListener) : RecyclerView.ViewHolder(binding.root), View.OnClickListener{
        private lateinit var menuItem: MenuItem

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(menuItem: MenuItem) {
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


        override fun onClick(view: View?) {
            view?.let {
                clickListener.onRecyclerViewItemClicked(menuItem)
            }
        }
    }
}

interface AdapterClickListener{
    fun onRecyclerViewItemClicked(menuItem: MenuItem)
}