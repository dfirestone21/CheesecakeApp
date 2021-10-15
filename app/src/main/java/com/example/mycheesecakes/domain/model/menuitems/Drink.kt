package com.example.mycheesecakes.domain.model.menuitems

class Drink(
    override val name: String,
    val shots: Int,
    val milk: Milk,
    val foam: Foam,
    val hasWhip: Boolean,
    val glassware: Glassware,
    val otherIngredients: String,
    val garnish: String,
    val straw: Straw,
    override val imageURL: String,
    override val id: String? = null
) : MenuItem(id = id, name = name, imageURL = imageURL) {



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
        },
        NONE {
            override fun toString() = "None"
        };
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
    }
}