package com.example.mycheesecakes.model

import com.example.mycheesecakes.model.Category.*
import com.example.mycheesecakes.model.desserts.MenuItem
import kotlin.collections.HashMap

class Cheesecake(
        name: String,
        val cheesecake: String,
        val crust: String,
        val nuts: String,
        val dollops: String,
        val topping: String,
        val presentation: String,
        val categories: Set<Category>,
        imageURL: String
)  : MenuItem(name, imageURL){

        override fun getDescription(): HashMap<String, String> {
                val descriptionMap = HashMap<String, String>()
                descriptionMap["Name"] = name
                descriptionMap["Crust"] = crust
                descriptionMap["Nuts"] = nuts
                descriptionMap["Dollops"] = dollops
                descriptionMap["Topping"] = topping
                descriptionMap["Presentation"] = presentation
                descriptionMap["Categories"] = categories.joinToString()

                return descriptionMap
        }
}

val allCheesecakeList: List<Cheesecake> = listOf(
        Cheesecake("30th Anniversary Chocolate Cake",
                "Original cheesecake", "Creamy chocolate fudge cake", "None", "One", "Chocolate cream, crunchy pearls of chocolate",
                "Whip", setOf(CHOCOLATE, CAKE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_30thChocolateAnnivCheesecake.jpg"),
        Cheesecake("Adam’s Peanut Butter Cup Fudge Ripple", "Original with Reese's and Butterfingers",
                "Chocolate", "Peanuts", "One", "Peanut Butter cream cheese rosette, Reece's, Butterfinger", "Whip",
                setOf(CANDY, NUTS,
                        KIDS_FAVE
                ), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_AdamsPeanutButterCupFudgeRipple.jpg"),
        Cheesecake("Caramel Apple Cheesecake", "Original cheesecake loaded with caramel apples",
                "Graham cracker", "None", "Two", "Caramel", "streusel sprinkled on whip", setOf(
                        KIDS_FAVE, FRUIT
                ),
                "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_CaramelAppleCheesecake.jpg"),
        Cheesecake("Caramel Pecan Turtle", "Caramel", "Pecan brownie", "Pecans", "One",
                "Caramel Turtle Pecans and Chocolate Ganache", "Whip", setOf(CHOCOLATE,NUTS
                ),
                "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_CaramelPecanTurtleCheesecake.jpg"),
        Cheesecake("Celebration Cake Cheesecake", "Layers of Vanilla Cake, Cheesecake, Strawberry, Chocolate and Vanilla Mousse", "Vanilla Cake",
                "None", "One, front", "Cream Cheese Frosting", "Whip and confetti sprinkled evenly over the entire plate and dessert",
                setOf(KIDS_FAVE, CHOCOLATE, MOUSSE
                ), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_CelebrationCheesecake.jpg"),
        Cheesecake("Chocolate Caramelicious Cheesecake Made with Snickers", "Original cheesecake swirled with Snickers", "Brownie", "Peanuts", "Two",
                "Snickers", "Whip, caramel and peanuts", setOf(CHOCOLATE, NUTS, KIDS_FAVE, CARAMEL),
                "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ChocolateCarameliciousCheesecake.jpg"),
        Cheesecake("Chocolate Hazelnut Crunch Cheesecake", "Hazelnut cheesecake with nutella swirls and roasted white chocolate cheesecake swirled throughout and topped with a layer of Hazelnut Mousse",
                "Blondie base with caramel and chocolate biscuit pieces", "Hazelnut", "Two", "Roasted White Chocolate Ganache zig zags and chocolate covered hazelnuts",
                "Whip and Nutella zigzagged over slice of cake", setOf(CHOCOLATE, NUTS, MOUSSE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ChocolateHazelnutCrunch.jpg"),
        Cheesecake("Chocolate Mousse", "Chocolate", "Chocolate", "None", "Two", "Chocolate shavings", "Whip",
                setOf(CHOCOLATE, MOUSSE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ChocolateMousseCheesecake.jpg"),
        Cheesecake("Chocolate Tuxedo Cream", "Chocolate", "Fudge cake", "None", "Two", "Light creamy mousse, white chocolate gan", "Whip",
                setOf(CHOCOLATE, MOUSSE, CAKE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ChocolateTuxedoCheesecake.jpg"),
        Cheesecake("Cinnabon Cinnamon Swirl Cheesecake", "Cinnabon Cinnamon cheesecake", "Vanilla crunch cake", "None", "One",
                "Cream cheese frosting and light caramel", "Caramel swirl on plate, cinnamon powdered sugar",
                setOf(KIDS_FAVE, CINNAMON), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_CinnabonCinnamonSwirlCheesecake.jpg"),
        Cheesecake("Dulce de Leche Caramel Cheesecake", "Caramel", "Vanilla", "Brickle", "Two", "Caramel Mousse", "Brickle (dollops only)",
                setOf(CARAMEL, MOUSSE, NUTS), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_DulceDeLecheCheesecake.jpg"),
        Cheesecake("Fresh Banana Cream Cheesecake", "Banana", "Vanilla", "None", "Two", "Banana Custard", "10-12 banana slices",
                setOf(FRUIT), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_BananaCreamCheesecake.jpg"),
        Cheesecake("Fresh Strawberry Cheesecake", "Original", "Graham cracker", "None", "Two", "None", "Whip and 3 glazed strawberries",
                setOf(FRUIT), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_FreshStrawberryCheesecake.jpg"),
        Cheesecake("Godiva Chocolate Cheesecake", "Godiva Chocolate with Chunks of Godiva", "Flourless chocolate cake", "None", "Two",
                "Chocolate Mousse with ganache, chocolate powder", "\'S\' on plate with w/ Chocolate square",
                setOf(CHOCOLATE, CAKE, MOUSSE, CANDY, GLUTEN_FREE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_GodivaCheesecake.jpg"),
        Cheesecake("Hershey's Chocolate Bar Cheesecake", "Hershey's Chocolate Cheesecake", "Chocolate cake", "None", "One",
                "Ganache with creamy chocolate frosting and chocolate chips", "Whip with chocolate squiggle and Hershey's chocolate in dallop",
                setOf(CHOCOLATE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_HersheysCheesecake.jpg"),
        Cheesecake("Kahlua Cocoa Coffee Cheesecake", "Coffee Swirled with Kahlua Liqueur", "Brownie", "None", "Two",
                "Coffee Chocolate Mousse", "Whip",
                setOf(COFFEE, LIQUEUR, MOUSSE), "https://img.sndimg.com/food/image/upload/c_thumb,q_80,w_562,h_316/v1/img/recipes/15/33/0/picLvIGGT.jpg"),
        Cheesecake("Key Lime Cheesecake", "Key lime", "Vanilla", "None", "Two", "N/A", "Quarter lime wheel",
                setOf(FRUIT), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_KeyLimeCheesecake.jpg"),
        Cheesecake("Lemon Meringue Cheesecake", "Lemon cream", "Vanilla Crumb", "None", "One",
                "Lemon mascarpone mousse, lemon curd and housemade meringue", "Pipe zig-zags of marshmallow cream, then toast. Garnish with mint sprig and candied lemon zest",
                setOf(FRUIT), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_LemonMeringue.jpg"),
                Cheesecake("Lemon Raspberry Cream Cheesecake", "Lemon with seedless imported raspberries", "Ladyfingers/White cake", "None", "Two",
                "Lemon mousse", "One pasta spoon of raspberry puree",
                setOf(FRUIT, MOUSSE, CAKE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_LemonRaspberryCreamCheesecake.jpg"),
        Cheesecake("Low-Licious Cheesecake", "Similar to original", "Similar to original, but without nuts", "None", "One dollop of Low-Licious whip",
                "None", "Mint sprig", setOf(LOW_CARB, GLUTEN_FREE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_LowLicious.jpg"),
        Cheesecake("Low-Licious Cheesecake with Fresh Strawberries", "Similar to original", "Similar to original, but without nuts", "None", "One dollop of Low-Licious whip",
                "None", "Mint sprig and a bullet of strawberries", setOf(LOW_CARB, GLUTEN_FREE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_LowLiciousStrawberry.jpg"),
        Cheesecake("Mango Key Lime Cheesecake", "Mango key lime", "Coconut macaroon", "None", "Two", "Mango mousse", "Whip",
                setOf(FRUIT), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_MangoKeyLimeCheesecake.jpg"),
        Cheesecake("Oreo Dream Extreme Cheesecake", "Original with Oreo cookies", "Chocolate", "None", "One", "Oreo cookie wafer with 1/2 oz of Oreo Crumbles",
                "One front dollop with an Oreo cookie wafer and 1/2 oz of Oreo Crumbles",
                setOf(CHOCOLATE, KIDS_FAVE), "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_OreoDreamExtremeCheesecake.jpg"),
        Cheesecake("Original", "Original", "Graham cracker", "None", "One", "Sour cream", "Whip", setOf(),
                "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_OriginalCheesecake.jpg"),
        Cheesecake("Peppermint Bark Cheesecake","White Chocolate Sweet Cream with a Peppermint Swirl, red and white mints, and dark chocolate flakes","Peppermint flourless chocolate cake",
        "None","Two","White chocolate Peppermint mousse with red and white mints and dark chocolate flakes","Crushed peppermint candy sprinkled over whip dollops, cheesecake and plate",
            setOf(SEASONAL,CANDY),"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_PeppermintBarkCheesecake.jpg"),
        Cheesecake("Pineapple Upside-Down Cheesecake","Pineapple Sweet Cream Cheesecake with a Maraschino Cherry Swirl","Pineapple Upside-Down cake","None","Two",
                "Crushed pineapple with chopped Marachino cherries","Cherry placed (stem up) on back dollop",
            setOf(FRUIT),"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_PineappleUpsideDownCheesecake.jpg"),
        Cheesecake("Pumpkin Cheesecake","Pumpkin","Graham cracker","None","Two","N/A","Whip", setOf(FRUIT),
            "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_PumpkinCheesecake.jpg"),
        Cheesecake("Pumpkin Pecan Cheesecake","Pumpkin with Pecan Pie underneath","Pastry","Pecans","Two","Pecan halves","Whip",
            setOf(FRUIT,NUTS,PASTRY),"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_PumpkinPecanCheesecake.jpg"),
        Cheesecake("Reese's Peanut Butter Chocolate Cake Cheesecake","Original","Fudge cake","Peanuts","One","N/A","Whip",
            setOf(CHOCOLATE, CAKE, NUTS),"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ReesesPBChocCakeCheesecake.jpg"),
        Cheesecake("Salted Caramel Cheesecake","Caramel","Blonde brownie","None","One","Creamy caramel mousse, salted caramel",
                "Caramel loop de loop", setOf(CARAMEL),"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_SaltedCaramelCheesecake.jpg"),
        Cheesecake("Tiramisu Cheesecake","Coffee with mars wine, coffee liqueur, esp, ladyfingers","White cake soaked in Coffee Liqueur","None","One",
                "Mascarpone cream, chocolate whipped rosette", "Chocolate powder",
                setOf(COFFEE,LIQUEUR,CAKE),"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_TiramisuCheesecake.jpg"),
        Cheesecake("Toasted Marshmallow S'mores Galore","Hershey's cheesecake with chocolate ganache","Cookie crumb","None","Two",
                "Marshmallow cream, Graham cracker pieces, Graham cracker square","Whip, Marshmallow cream, graham cracker pieces, graham cracker square",
                setOf(CHOCOLATE),"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ToastedMarsmallowSmoresGalore.jpg"),
        Cheesecake("Ultimate Red Velvet Cake Cheesecake","Original","Red velvet cake","None","One","Cream cheese icing, finished with white chocolate",
                "Whip", setOf(CAKE),"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_RedVelvetCheesecake.jpg"),
        Cheesecake("Vanilla Bean Cheesecake","Vanilla","Vanilla (crunchy, buttery)","None","Two","Vanilla mousse, Vanilla whipped cream","Whip",
            setOf(VANILLA),"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_VanillaBeanCheesecake.jpg"),
        Cheesecake("Very Cherry Ghirardelli Chocolate Cheesecake","Cherry cheesecake","Fudge cake","None","Two","Whipped cream dollops with chocolate chips",
            "Zig zags of chocolate syrup", setOf(FRUIT,CHOCOLATE),"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_VeryCherryGhirardelliChocolateCheesecake.jpg"),
        Cheesecake("White Chocolate Raspberry Truffle","Original with seedless imported raspberries and white chocolate","Chocolate","None","Two",
                "White chocolate shavings","Whip", setOf(FRUIT,CHOCOLATE),"https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_WhiteChocolateRaspberryTruffle.jpg")

)

enum class Category(val nameString: String) {
        CHOCOLATE("Chocolate Lover"),
        FRUIT("Fruit"),
        NUTS("Nuts"),
        MOUSSE("Mousse"),
        CARAMEL("Caramel"),
        CANDY("Candy"),
        CAKE("Cake"),
        KIDS_FAVE("Kids' Favorite"),
        CINNAMON("Cinnamon Lover"),
        GLUTEN_FREE("Gluten Free"),
        COFFEE("Coffee"),
        LIQUEUR("Liqueur"),
        LOW_CARB("Low Carb"),
        SEASONAL("Seasonal"),
        PASTRY("Pastry"),
        VANILLA("Vanilla")
}


