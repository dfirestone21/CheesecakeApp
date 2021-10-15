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
                    (binding as FragmentFlashcardDetailsCheesecakeBinding).apply {
                        detailsCheesecakeCheescakePropertyTextview.text = menuItem.cheesecake
                        detailsCheesecakeCrustPropertyTextview.text = menuItem.crust
                        detailsCheesecakeDollopsPropertyTextview.text = menuItem.dollops
                        detailsCheesecakeNamePropertyTextview.text = menuItem.name
                        if (menuItem.nuts != Nuts.NONE) {
                            detailsCheesecakeNutsTextview.setTextColor(Color.RED)
                            detailsCheesecakeNutsPropertyTextview.setTextColor(Color.RED)
                        }
                        detailsCheesecakeNutsPropertyTextview.text = menuItem.nuts.toString()
                        detailsCheesecakePresentationPropertyTextview.text = menuItem.presentation
                        detailsCheesecakeToppingPropertyTextview.text = menuItem.topping
                    }
            }
            (menuItem is Dessert) -> {
                (binding as FragmentFlashcardDetailsDessertBinding).apply {
                    detailsDessertBasePropertyTextview.text = menuItem.base
                    detailsDessertDishesTextviewProperty.text = menuItem.dishes.toString()
                    detailsDessertFudgePropertyTextview.text = menuItem.fudge
                    detailsDessertIceCreamPropertyTextview.text = menuItem.iceCream
                    detailsDessertNameTextviewProperty.text = menuItem.name
                    detailsDessertWhipPropertyTextview.text = menuItem.whippedCream
                }
            }
            (menuItem is Drink) -> {
                (binding as FragmentFlashcardDetailsDrinkBinding).apply {
                    drinkEspressoShotsValueTextview.text = menuItem.shots.toString()
                    drinkMilkValueTextview.text = menuItem.milk.toString()
                    drinkFoamValueTextview.text = menuItem.foam.toString()
                    drinkWhipValueTextview.text = menuItem.hasWhip.toString()
                    drinkGlasswareValueTextview.text = menuItem.glassware.toString()
                    drinkOtherIngredientsValueTextview.text = menuItem.otherIngredients
                    drinkGarnishValueTextview.text = menuItem.garnish
                    drinkStrawValueTextview.text = menuItem.straw.toString()
                }
            }
            else -> throw IllegalArgumentException("Invalid menuItem")
        }
    }

}



//TODO use when statement to select the correct binding. Base it off of the viewmodel's menuItemType property.