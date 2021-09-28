package com.example.mycheesecakes.domain.model.menuitems

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

    override fun getProperties(): HashMap<String, String> {
        val propertyMap = HashMap<String, String>()

        propertyMap["Name"] = name
        propertyMap["Shots"] = shots.toString()
        propertyMap["Milk"] = milk.toString()
        propertyMap["Foam"] = foam.toString()
        propertyMap["Whip"] = hasWhip.toString()
        propertyMap["Glassware"] = glassware.toString()
        propertyMap["Other Ingredients"] = otherIngredients
        propertyMap["Garnish"] = garnish
        propertyMap["Straw"] = straw.toString()

        return propertyMap
    }

    enum class Foam {
        NONE {
            override fun toString() = "None"
        },
        SHORT {
            override fun toString() = "Short Foam (3 seconds)"
        },
        LONG {
            override fun toString() = "Long Foam (5 seconds)"
        };

        override fun toString() = ""
    }

    enum class Milk {
        NONE {
            override fun toString() = "None"
        },
        SIX {
            override fun toString() = "6 fz"
        },
        NINE {
            override fun toString() = "9 fz"
        },
        TEN {
            override fun toString() = "10 fz"
        },
        TWELVE {
            override fun toString() = "12 fz"
        };

        override fun toString() = ""

    }

    enum class Glassware {
        ESPRESSO {
            override fun toString() = "Espresso"
        },
        CAPPUCCINO {
            override fun toString() = "Cappuccino"
        },
        PINT {
            override fun toString() = "Pint Glass"
            var hasJavaJacket = false
        },
        COLLINS {
            override fun toString() = "Collins"
        },
        KIDS {
            override fun toString() = "Kids' Cup"
        };

        override fun toString() = ""
    }

    enum class Straw {
        NONE {
            override fun toString() = "None"
        },
        TALL_SIP {
            override fun toString() = "2 Tall Sip Straws"
        },
        TURBO {
            override fun toString() = "1 Turbo Straw"
        };

        override fun toString() = ""
    }
}