package com.example.mycheesecakes.domain.model.menuitems.util

import com.example.mycheesecakes.domain.model.Category
import com.example.mycheesecakes.domain.model.Cheesecake
import com.example.mycheesecakes.domain.model.Nuts

val allCheesecakeList: List<Cheesecake> = listOf(
    Cheesecake(
        "30th Anniversary Chocolate Cake",
        "Original cheesecake",
        "Creamy chocolate fudge cake",
        Nuts.NONE                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       ,
        "One",
        "Chocolate cream, crunchy pearls of chocolate",
        "Whip",
        setOf(Category.CHOCOLATE, Category.CAKE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_30thChocolateAnnivCheesecake.jpg"
    ),
    Cheesecake(
        "Adam’s Peanut Butter Cup Fudge Ripple",
        "Original with Reese's and Butterfingers",
        "Chocolate",
        Nuts.PEANUTS,
        "One",
        "Peanut Butter cream cheese rosette, Reece's, Butterfinger",
        "Whip",
        setOf(
            Category.CANDY, Category.NUTS,
            Category.KIDSFAVE
        ),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_AdamsPeanutButterCupFudgeRipple.jpg"
    ),
    Cheesecake(
        "Caramel Apple Cheesecake", "Original cheesecake loaded with caramel apples",
        "Graham cracker", Nuts.NONE, "Two", "Caramel", "streusel sprinkled on whip", setOf(
            Category.KIDSFAVE, Category.FRUIT
        ),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_CaramelAppleCheesecake.jpg"
    ),
    Cheesecake(
        "Caramel Pecan Turtle", "Caramel", "Pecan brownie", Nuts.PECANS, "One",
        "Caramel Turtle Pecans and Chocolate Ganache", "Whip", setOf(
            Category.CHOCOLATE, Category.NUTS
        ),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_CaramelPecanTurtleCheesecake.jpg"
    ),
    Cheesecake(
        "Celebration Cake Cheesecake",
        "Layers of Vanilla Cake, Cheesecake, Strawberry, Chocolate and Vanilla Mousse",
        "Vanilla Cake",
        Nuts.NONE,
        "One, front",
        "Cream Cheese Frosting",
        "Whip and confetti sprinkled evenly over the entire plate and dessert",
        setOf(
            Category.KIDSFAVE, Category.CHOCOLATE, Category.MOUSSE
        ),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_CelebrationCheesecake.jpg"
    ),
    Cheesecake(
        "Chocolate Caramelicious Cheesecake Made with Snickers",
        "Original cheesecake swirled with Snickers",
        "Brownie",
        Nuts.PEANUTS,
        "Two",
        "Snickers",
        "Whip, caramel and peanuts",
        setOf(Category.CHOCOLATE, Category.NUTS, Category.KIDSFAVE, Category.CARAMEL),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ChocolateCarameliciousCheesecake.jpg"
    ),
    Cheesecake(
        "Chocolate Hazelnut Crunch Cheesecake",
        "Hazelnut cheesecake with nutella swirls and roasted white chocolate cheesecake swirled throughout and topped with a layer of Hazelnut Mousse",
        "Blondie base with caramel and chocolate biscuit pieces",
        Nuts.HAZELNUTS,
        "Two",
        "Roasted White Chocolate Ganache zig zags and chocolate covered hazelnuts",
        "Whip and Nutella zigzagged over slice of cake",
        setOf(Category.CHOCOLATE, Category.NUTS, Category.MOUSSE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ChocolateHazelnutCrunch.jpg"
    ),
    Cheesecake(
        "Chocolate Mousse",
        "Chocolate",
        "Chocolate",
        Nuts.NONE,
        "Two",
        "Chocolate shavings",
        "Whip",
        setOf(Category.CHOCOLATE, Category.MOUSSE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ChocolateMousseCheesecake.jpg"
    ),
    Cheesecake(
        "Chocolate Tuxedo Cream",
        "Chocolate",
        "Fudge cake",
        Nuts.NONE,
        "Two",
        "Light creamy mousse, white chocolate gan",
        "Whip",
        setOf(Category.CHOCOLATE, Category.MOUSSE, Category.CAKE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ChocolateTuxedoCheesecake.jpg"
    ),
    Cheesecake(
        "Cinnabon Cinnamon Swirl Cheesecake",
        "Cinnabon Cinnamon cheesecake",
        "Vanilla crunch cake",
        Nuts.NONE,
        "One",
        "Cream cheese frosting and light caramel",
        "Caramel swirl on plate, cinnamon powdered sugar",
        setOf(Category.KIDSFAVE, Category.CINNAMON),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_CinnabonCinnamonSwirlCheesecake.jpg"
    ),
    Cheesecake(
        "Dulce de Leche Caramel Cheesecake",
        "Caramel",
        "Vanilla",
        Nuts.BRICKLE,
        "Two",
        "Caramel Mousse",
        "Brickle (dollops only)",
        setOf(Category.CARAMEL, Category.MOUSSE, Category.NUTS),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_DulceDeLecheCheesecake.jpg"
    ),
    Cheesecake(
        "Fresh Banana Cream Cheesecake",
        "Banana",
        "Vanilla",
        Nuts.NONE,
        "Two",
        "Banana Custard",
        "10-12 banana slices",
        setOf(Category.FRUIT),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_BananaCreamCheesecake.jpg"
    ),
    Cheesecake(
        "Fresh Strawberry Cheesecake",
        "Original",
        "Graham cracker",
        Nuts.NONE,
        "Two",
        "None",
        "Whip and 3 glazed strawberries",
        setOf(Category.FRUIT),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_FreshStrawberryCheesecake.jpg"
    ),
    Cheesecake(
        "Godiva Chocolate Cheesecake",
        "Godiva Chocolate with Chunks of Godiva",
        "Flourless chocolate cake",
        Nuts.NONE,
        "Two",
        "Chocolate Mousse with ganache, chocolate powder",
        "\'S\' on plate with w/ Chocolate square",
        setOf(
            Category.CHOCOLATE,
            Category.CAKE,
            Category.MOUSSE,
            Category.CANDY,
            Category.GLUTENFREE
        ),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_GodivaCheesecake.jpg"
    ),
    Cheesecake(
        "Hershey's Chocolate Bar Cheesecake",
        "Hershey's Chocolate Cheesecake",
        "Chocolate cake",
        Nuts.NONE,
        "One",
        "Ganache with creamy chocolate frosting and chocolate chips",
        "Whip with chocolate squiggle and Hershey's chocolate in dallop",
        setOf(Category.CHOCOLATE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_HersheysCheesecake.jpg"
    ),
    Cheesecake(
        "Kahlua Cocoa Coffee Cheesecake",
        "Coffee Swirled with Kahlua Liqueur",
        "Brownie",
        Nuts.NONE,
        "Two",
        "Coffee Chocolate Mousse",
        "Whip",
        setOf(Category.COFFEE, Category.LIQUEUR, Category.MOUSSE),
        "https://img.sndimg.com/food/image/upload/c_thumb,q_80,w_562,h_316/v1/img/recipes/15/33/0/picLvIGGT.jpg"
    ),
    Cheesecake(
        "Key Lime Cheesecake",
        "Key lime",
        "Vanilla",
        Nuts.NONE,
        "Two",
        "N/A",
        "Quarter lime wheel",
        setOf(Category.FRUIT),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_KeyLimeCheesecake.jpg"
    ),
    Cheesecake(
        "Lemon Meringue Cheesecake",
        "Lemon cream",
        "Vanilla Crumb",
        Nuts.NONE,
        "One",
        "Lemon mascarpone mousse, lemon curd and housemade meringue",
        "Pipe zig-zags of marshmallow cream, then toast. Garnish with mint sprig and candied lemon zest",
        setOf(Category.FRUIT),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_LemonMeringue.jpg"
    ),
    Cheesecake(
        "Lemon Raspberry Cream Cheesecake",
        "Lemon with seedless imported raspberries",
        "Ladyfingers/White cake",
        Nuts.NONE,
        "Two",
        "Lemon mousse",
        "One pasta spoon of raspberry puree",
        setOf(Category.FRUIT, Category.MOUSSE, Category.CAKE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_LemonRaspberryCreamCheesecake.jpg"
    ),
    Cheesecake(
        "Low-Licious Cheesecake",
        "Similar to original",
        "Similar to original, but without nuts",
        Nuts.NONE,
        "One dollop of Low-Licious whip",
        "None",
        "Mint sprig",
        setOf(Category.LOWCARB, Category.GLUTENFREE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_LowLicious.jpg"
    ),
    Cheesecake(
        "Low-Licious Cheesecake with Fresh Strawberries",
        "Similar to original",
        "Similar to original, but without nuts",
        Nuts.NONE,
        "One dollop of Low-Licious whip",
        "None",
        "Mint sprig and a bullet of strawberries",
        setOf(Category.LOWCARB, Category.GLUTENFREE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_LowLiciousStrawberry.jpg"
    ),
    Cheesecake(
        "Mango Key Lime Cheesecake",
        "Mango key lime",
        "Coconut macaroon",
        Nuts.NONE,
        "Two",
        "Mango mousse",
        "Whip",
        setOf(Category.FRUIT),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_MangoKeyLimeCheesecake.jpg"
    ),
    Cheesecake(
        "Oreo Dream Extreme Cheesecake",
        "Original with Oreo cookies",
        "Chocolate",
        Nuts.NONE,
        "One",
        "Oreo cookie wafer with 1/2 oz of Oreo Crumbles",
        "One front dollop with an Oreo cookie wafer and 1/2 oz of Oreo Crumbles",
        setOf(Category.CHOCOLATE, Category.KIDSFAVE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_OreoDreamExtremeCheesecake.jpg"
    ),
    Cheesecake(
        "Original", "Original", "Graham cracker", Nuts.NONE, "One", "Sour cream", "Whip", setOf(),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_OriginalCheesecake.jpg"
    ),
    Cheesecake(
        "Peppermint Bark Cheesecake",
        "White Chocolate Sweet Cream with a Peppermint Swirl, red and white mints, and dark chocolate flakes",
        "Peppermint flourless chocolate cake",
        Nuts.NONE,
        "Two",
        "White chocolate Peppermint mousse with red and white mints and dark chocolate flakes",
        "Crushed peppermint candy sprinkled over whip dollops, cheesecake and plate",
        setOf(Category.SEASONAL, Category.CANDY),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_PeppermintBarkCheesecake.jpg"
    ),
    Cheesecake(
        "Pineapple Upside-Down Cheesecake",
        "Pineapple Sweet Cream Cheesecake with a Maraschino Cherry Swirl",
        "Pineapple Upside-Down cake",
        Nuts.NONE,
        "Two",
        "Crushed pineapple with chopped Marachino cherries",
        "Cherry placed (stem up) on back dollop",
        setOf(Category.FRUIT),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_PineappleUpsideDownCheesecake.jpg"
    ),
    Cheesecake(
        "Pumpkin Cheesecake",
        "Pumpkin",
        "Graham cracker",
        Nuts.NONE,
        "Two",
        "N/A",
        "Whip",
        setOf(Category.FRUIT),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_PumpkinCheesecake.jpg"
    ),
    Cheesecake(
        "Pumpkin Pecan Cheesecake",
        "Pumpkin with Pecan Pie underneath",
        "Pastry",
        Nuts.PECANS,
        "Two",
        "Pecan halves",
        "Whip",
        setOf(Category.FRUIT, Category.NUTS, Category.PASTRY),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_PumpkinPecanCheesecake.jpg"
    ),
    Cheesecake(
        "Reese's Peanut Butter Chocolate Cake Cheesecake",
        "Original",
        "Fudge cake",
        Nuts.PEANUTS,
        "One",
        "N/A",
        "Whip",
        setOf(Category.CHOCOLATE, Category.CAKE, Category.NUTS),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ReesesPBChocCakeCheesecake.jpg"
    ),
    Cheesecake(
        "Salted Caramel Cheesecake",
        "Caramel",
        "Blonde brownie",
        Nuts.NONE,
        "One",
        "Creamy caramel mousse, salted caramel",
        "Caramel loop de loop",
        setOf(Category.CARAMEL),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_SaltedCaramelCheesecake.jpg"
    ),
    Cheesecake(
        "Tiramisu Cheesecake",
        "Coffee with mars wine, coffee liqueur, esp, ladyfingers",
        "White cake soaked in Coffee Liqueur",
        Nuts.NONE,
        "One",
        "Mascarpone cream, chocolate whipped rosette",
        "Chocolate powder",
        setOf(Category.COFFEE, Category.LIQUEUR, Category.CAKE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_TiramisuCheesecake.jpg"
    ),
    Cheesecake(
        "Toasted Marshmallow S'mores Galore",
        "Hershey's cheesecake with chocolate ganache",
        "Cookie crumb",
        Nuts.NONE,
        "Two",
        "Marshmallow cream, Graham cracker pieces, Graham cracker square",
        "Whip, Marshmallow cream, graham cracker pieces, graham cracker square",
        setOf(Category.CHOCOLATE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_ToastedMarsmallowSmoresGalore.jpg"
    ),
    Cheesecake(
        "Ultimate Red Velvet Cake Cheesecake",
        "Original",
        "Red velvet cake",
        Nuts.NONE,
        "One",
        "Cream cheese icing, finished with white chocolate",
        "Whip",
        setOf(Category.CAKE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_RedVelvetCheesecake.jpg"
    ),
    Cheesecake(
        "Vanilla Bean Cheesecake",
        "Vanilla",
        "Vanilla (crunchy, buttery)",
        Nuts.NONE,
        "Two",
        "Vanilla mousse, Vanilla whipped cream",
        "Whip",
        setOf(Category.VANILLA),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_VanillaBeanCheesecake.jpg"
    ),
    Cheesecake(
        "Very Cherry Ghirardelli Chocolate Cheesecake",
        "Cherry cheesecake",
        "Fudge cake",
        Nuts.NONE,
        "Two",
        "Whipped cream dollops with chocolate chips",
        "Zig zags of chocolate syrup",
        setOf(Category.FRUIT, Category.CHOCOLATE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_VeryCherryGhirardelliChocolateCheesecake.jpg"
    ),
    Cheesecake(
        "White Chocolate Raspberry Truffle",
        "Original with seedless imported raspberries and white chocolate",
        "Chocolate",
        Nuts.NONE,
        "Two",
        "White chocolate shavings",
        "Whip",
        setOf(Category.FRUIT, Category.CHOCOLATE),
        "https://www.thecheesecakefactory.com/assets/images/Menu-Import/CCF_WhiteChocolateRaspberryTruffle.jpg"
    )
)