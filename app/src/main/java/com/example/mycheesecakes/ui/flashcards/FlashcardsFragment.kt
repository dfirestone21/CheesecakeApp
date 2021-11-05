package com.example.mycheesecakes.ui.flashcards

import android.graphics.Rect
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelStoreOwner
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycheesecakes.R
import com.example.mycheesecakes.databinding.FragmentFlashcardsBinding
import java.lang.IllegalArgumentException
import com.example.mycheesecakes.domain.model.menuitems.*

class FlashcardsFragment() : Fragment(), AdapterClickListener {
    private lateinit var binding: FragmentFlashcardsBinding
    private lateinit var adapter: FlashcardsRecyclerAdapter
    private lateinit var viewModel: FlashcardsViewModel
    private lateinit var menuItems: List<MenuItem>
    private lateinit var menuItem: MenuItem
    private var menuItemType: Int = 0

    private val TAG = "FlashcardsFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(TAG, "onCreateView called")
        binding = FragmentFlashcardsBinding.inflate(inflater)

        // Get menuItemType from arguments
        val bundle = arguments
        val args = FlashcardsFragmentArgs.fromBundle(requireArguments())
        menuItemType = args.menuItemType

        // Setup the ViewModel
        val viewModelFactory = FlashcardsViewModelFactory(menuItemType)
        viewModel = ViewModelProvider(activity as ViewModelStoreOwner, viewModelFactory).get(FlashcardsViewModel::class.java)

        if (menuItemType != viewModel.menuItemType) {
            viewModel.onMenuItemTypeChanged(menuItemType)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(TAG, "onViewCreated called")
        super.onViewCreated(view, savedInstanceState)

        viewModel.menuItemsLiveData.observe(viewLifecycleOwner) {
            menuItems = it
            Log.i(TAG,"menuItems changed: ${menuItems[0]}")
            setupRecyclerView()
        }
    }


    private fun setupRecyclerView() {
        Log.i(TAG, "setupRecyclerView called")
        binding.flashcardsRecyclerview.visibility = RecyclerView.VISIBLE
        binding.progressBar1.visibility = RecyclerView.GONE
        adapter = FlashcardsRecyclerAdapter(menuItems, this)
        binding.flashcardsRecyclerview.layoutManager = LinearLayoutManager(context)
        binding.flashcardsRecyclerview.adapter = adapter
        binding.flashcardsRecyclerview.addItemDecoration(
            FlashcardsItemDecoration(
                resources.getDimension(
                    R.dimen.default_margin
                ).toInt()
            )
        )
        val onScrollListener = FlashcardsOnScrollListener()
    }

    // Used to set a given space in pixels around the CardViews
    private class FlashcardsItemDecoration(private val spaceHeight: Int) :
        RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            with(outRect) {
                if (parent.getChildAdapterPosition(view) == 0) {
                    top = spaceHeight
                }
                left = spaceHeight
                right = spaceHeight
                bottom = spaceHeight
            }
        }
    }

    private class FlashcardsOnScrollListener(): RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
        }
    }

    override fun onRecyclerViewItemClicked(menuItem: MenuItem) {
        Log.i(TAG,"onRecyclerViewItemClicked called. menuItem: ${menuItem.name}")
        viewModel.onMenuItemFlashcardSelected(menuItem)

        val action =
            FlashcardsFragmentDirections.actionFlashcardsFragmentToFlashcardDetailsFragment(menuItemType)
        findNavController().navigate(action)
    }

}

// TODO add search and filter buttons in the acton bar
// TODO add a favorites option with each flashcard that assigns it to the top of the list