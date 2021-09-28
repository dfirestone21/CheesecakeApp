package com.example.mycheesecakes.ui.flashcards

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.viewbinding.ViewBinding
import com.example.mycheesecakes.R
import com.example.mycheesecakes.databinding.FragmentFlashcardDetailsCheesecakeBinding
import com.example.mycheesecakes.databinding.FragmentFlashcardDetailsDessertBinding
import com.example.mycheesecakes.databinding.FragmentFlashcardDetailsDrinkBinding
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.Nuts
import com.example.mycheesecakes.domain.model.menuitems.*
import java.lang.IllegalArgumentException


class FlashcardDetailsFragment : Fragment() {
    private lateinit var binding: ViewBinding
    //private var menuItem: MenuItem? = null
    private lateinit var viewModel: FlashcardsViewModel
    private var menuItemType: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Get menuItemType from arguments
        val bundle = arguments
        val args = FlashcardsFragmentArgs.fromBundle(requireArguments())
        menuItemType = args.menuItemType

        // Setup the ViewModel
        val viewModelFactory = FlashcardsViewModelFactory(menuItemType)
        viewModel = ViewModelProvider(activity as ViewModelStoreOwner, viewModelFactory).get(FlashcardsViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        binding = when (menuItemType) {
            MENU_ITEM_CHEESECAKE -> FragmentFlashcardDetailsCheesecakeBinding.inflate(inflater)
            MENU_ITEM_DESSERT -> FragmentFlashcardDetailsDessertBinding.inflate(inflater)
            MENU_ITEM_DRINK -> FragmentFlashcardDetailsDrinkBinding.inflate(inflater)
            else -> throw IllegalArgumentException("Invalid menuItemType")
        }



        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.menuItemLiveData.observe(viewLifecycleOwner, { item ->
            //menuItem = item
            bindPropertiesToViews(item)
        })
    }


    private fun bindPropertiesToViews(menuItem: MenuItem) {
        when {
            (menuItem is Cheesecake) -> {
                    val propertyMap = menuItem.getProperties()
                    (binding as FragmentFlashcardDetailsCheesecakeBinding).apply {
                        detailsCheesecakeCheescakeTextview.text = getString(R.string.cheesecake_flashcard)
                        detailsCheesecakeCheescakePropertyTextview.text = propertyMap["Cheesecake"]
                        detailsCheesecakeCrustTextview.text = getString(R.string.crust_flashcard)
                        detailsCheesecakeCrustPropertyTextview.text = propertyMap["Crust"]
                        detailsCheeescakeDollopsTextview.text = getString(R.string.dollops_flashcard)
                        detailsCheesecakeDollopsPropertyTextview.text = propertyMap["Dollops"]
                        detailsCheesecakeNamePropertyTextview.text = propertyMap["Name"]
                        detailsCheesecakeNutsTextview.text = getString(R.string.nuts_flashcard)
                        if (menuItem.nuts != Nuts.NONE) {
                            detailsCheesecakeNutsTextview.setTextColor(Color.RED)
                            detailsCheesecakeNutsPropertyTextview.setTextColor(Color.RED)
                        }
                        detailsCheesecakeNutsPropertyTextview.text = propertyMap["Nuts"]
                        detailsCheesecakePresentationTextview.text = getString(R.string.presentation_flashcard)
                        detailsCheesecakePresentationPropertyTextview.text = propertyMap["Presentation"]
                        detailsCheesecakeToppingTextview.text = getString(R.string.topping_flashcard)
                        detailsCheesecakeToppingPropertyTextview.text = propertyMap["Topping"]
                    }
            }
            (menuItem is Dessert) -> {
                val propertyMap = menuItem.getProperties()
                (binding as FragmentFlashcardDetailsDessertBinding).apply {
                    detailsDessertBaseTextview.text = "Base:"
                    detailsDessertBasePropertyTextview.text = propertyMap["Base"]
                    detailsDessertDishesTextview.text = "Dishes:"
                    detailsDessertDishesTextviewProperty.text = propertyMap["Dishes"]
                    detailsDessertFudgeTextview.text = "Fudge:"
                    detailsDessertFudgePropertyTextview.text = propertyMap["Fudge"]
                    detailsDessertIceCreamTextview.text = "Ice Cream:"
                    detailsDessertIceCreamPropertyTextview.text = propertyMap["Ice Cream"]
                    detailsDessertNameTextviewProperty.text = propertyMap["Name"]
                    detailsDessertToppingTextview.text = "Toppings:"
                    detailsDessertToppingPropertyTextview.text = propertyMap["Toppings"]
                    detailsDessertWhipTextview.text = "Whipped Cream:"
                    detailsDessertWhipPropertyTextview.text = propertyMap["Whipped Cream"]
                }
            }
            else -> throw IllegalArgumentException("Invalid menuItem")
        }
    }

}



//TODO use when statement to select the correct binding. Base it off of the viewmodel's menuItemType property.