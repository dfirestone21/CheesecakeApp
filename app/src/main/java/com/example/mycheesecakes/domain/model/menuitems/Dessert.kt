package com.example.mycheesecakes.domain.model.menuitems

class Dessert(
        override val name: String,
        override val imageURL: String,
        val dishes: Set<String>,
        val base: String,
        val iceCream: String,
        val fudge: String,
        val whippedCream: String,
        val toppings: String
) : MenuItem(name, imageURL){

        override fun getProperties(): HashMap<String, String> {
                val descriptionMap = HashMap<String,String>()
                descriptionMap["Name"] = name
                descriptionMap["Dishes"] = dishes.joinToString()
                descriptionMap["Base"] = base
                descriptionMap["Ice Cream"] = iceCream
                descriptionMap["Fudge"] = fudge
                descriptionMap["Whipped Cream"] = whippedCream
                descriptionMap["Toppings"] = toppings

                return descriptionMap
        }
}