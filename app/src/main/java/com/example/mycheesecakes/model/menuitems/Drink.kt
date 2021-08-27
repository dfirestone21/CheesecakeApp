package com.example.mycheesecakes.model.menuitems

class Drink(
    name: String,
    val shots: Int,
    val milk: Milk,
    val foam: Foam,
    val hasWhip: Boolean,
    val glassware: Glassware,
    val otherIngredients: String,
    val garnish: String,
    val straw: Straw,
    imageURL: String
) : MenuItem(name, imageURL) {

    override fun getDescription(): HashMap<String, String> {
        val descriptionMap = HashMap<String, String>()

        descriptionMap["Name"] = name
        descriptionMap["Shots"] = shots.toString()
        descriptionMap["Milk"] = milk.nameString
        descriptionMap["Foam"] = foam.nameString
        descriptionMap["Whip"] = hasWhip.toString()
        descriptionMap["Glassware"] = glassware.nameString
        descriptionMap["Other Ingredients"] = otherIngredients
        descriptionMap["Garnish"] = garnish
        descriptionMap["Straw"] = straw.nameString

        return descriptionMap
    }

    enum class Foam {
        NONE {
            override val nameString = "None"
        },
        SHORT {
            override val nameString = "Short Foam (3 seconds)"
        },
        LONG {
            override val nameString = "Long Foam (5 seconds)"
        };

        open val nameString = ""
    }

    enum class Milk {
        NONE {
            override val nameString = "None"
        },
        SIX {
            override val nameString = "6 fz"
        },
        NINE {
            override val nameString = "9 fz"
        },
        TEN {
            override val nameString = "10 fz"
        },
        TWELVE {
            override val nameString = "12 fz"
        };

        open val nameString = ""

    }

    enum class Glassware {
        ESPRESSO {
            override val nameString = "Espresso"
        },
        CAPPUCCINO {
            override val nameString = "Cappuccino"
        },
        PINT {
            override val nameString = "Pint Glass"
            var hasJavaJacket = false
        },
        COLLINS {
            override val nameString = "Collins"
        },
        KIDS {
            override val nameString = "Kids' Cup"
        };

        open val nameString = ""
    }

    enum class Straw {
        NONE {
            override val nameString = "None"
        },
        TALL_SIP {
            override val nameString = "2 Tall Sip Straws"
        },
        TURBO {
            override val nameString = "1 Turbo Straw"
        };

        open val nameString = ""
    }
}