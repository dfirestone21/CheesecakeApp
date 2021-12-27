package com.example.mycheesecakes.domain.model

import com.example.mycheesecakes.domain.model.Category.*
import com.example.mycheesecakes.domain.model.menuitems.MenuItem
import kotlin.collections.HashMap

class Cheesecake(
    override val name: String,
    val cheesecake: String,
    val crust: String,
    val nuts: Nuts,
    val dollops: String,
    val topping: String,
    val presentation: String,
    val categories: Set<Category>,  // Change to List
    override val imageURL: String,
    override val id: String? = null,
) : MenuItem(id = id, name = name, imageURL = imageURL) {

}

enum class Category(val nameString: String) {
    CHOCOLATE("Chocolate Lover"),
    FRUIT("Fruit"),
    NUTS("Nuts"),
    MOUSSE("Mousse"),
    CARAMEL("Caramel"),
    CANDY("Candy"),
    CAKE("Cake"),
    KIDSFAVE("Kids' Favorite"),
    CINNAMON("Cinnamon"),
    GLUTENFREE("GlutenFree"),
    COFFEE("Coffee"),
    LIQUEUR("Liqueur"),
    LOWCARB("Low Carb"),
    SEASONAL("Seasonal"),
    PASTRY("Pastry"),
    VANILLA("Vanilla"),
}

enum class Nuts {
    //@SerializedName("None")
    NONE {
        override fun toString() = "None"
    },
    //@SerializedName("Peanuts")
    PEANUTS  {
        override fun toString() = "Peanuts"
    },
    //@SerializedName("Pecans")
    PECANS {
        override fun toString() = "Pecans"
    },
    //@SerializedName("Hazelnut")
    HAZELNUTS {
        override fun toString() = "Hazelnut"
    },
    //@SerializedName("Brickle")
    BRICKLE {
        override fun toString() = "Brickle"
    },
    HAZELNUT {
        override fun toString() = "Hazelnut"
    };

}
