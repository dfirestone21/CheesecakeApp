package com.example.mycheesecakes.data.network.api.model.mappers

import com.example.mycheesecakes.data.network.api.model.ApiDrink
import com.example.mycheesecakes.domain.model.menuitems.Drink
import java.lang.IllegalArgumentException

class ApiDrinkMapper: ApiMapper<ApiDrink,Drink> {
    override fun mapToDomain(apiEntity: ApiDrink): Drink {
        return Drink(
            name = apiEntity.fields?.name.orEmpty(),
            shots = apiEntity.fields?.shots ?: 0,
            milk = parseMilk(apiEntity.fields?.milk),
            foam = parseFoam(apiEntity.fields?.foam),
            hasWhip = apiEntity.fields?.whip ?: false,
            glassware = parseGlassware(apiEntity.fields?.glassware),
            otherIngredients = apiEntity.fields?.otherIngredients.orEmpty(),
            garnish = apiEntity.fields?.garnish.orEmpty(),
            straw = parseStraw(apiEntity.fields?.straws),
            imageURL = apiEntity.fields?.imageUrl.orEmpty()
        )
    }

    private fun parseMilk(milk: String?): Drink.Milk {
        return when (milk) {
            null, "None" -> Drink.Milk.NONE
            "6 fz" -> Drink.Milk.SIX
            "9 fz" -> Drink.Milk.NINE
            "10 fz" -> Drink.Milk.TEN
            "12 fz" -> Drink.Milk.TWELVE
            else -> throw IllegalArgumentException("Invalid Milk enum")
        }
    }

    private fun parseFoam(foam: String?): Drink.Foam {
        return when (foam) {
            null, "None" -> Drink.Foam.NONE
            "Long Foam" -> Drink.Foam.LONG
            "Short Foam" -> Drink.Foam.SHORT
            else -> throw IllegalArgumentException("Invalid Foam enum")
        }
    }

    private fun parseGlassware(glass: String?): Drink.Glassware {
        return when (glass) {
            null -> Drink.Glassware.NONE
            "Espresso Cup/Saucer" -> Drink.Glassware.ESPRESSO
            "Cappuccino Cup" -> Drink.Glassware.CAPPUCCINO
            "Pint Glass" -> Drink.Glassware.PINT
            "Collins" -> Drink.Glassware.COLLINS
            "Kids' Cup" -> Drink.Glassware.KIDS
            else -> throw IllegalArgumentException("Invalid Glass enum")
        }
    }

    private fun parseStraw(straw: String?): Drink.Straw {
        return when (straw) {
            null, "None" -> Drink.Straw.NONE
            "2 Tall Sip Straws" -> Drink.Straw.TALL_SIP
            "1 Turbo Straw" -> Drink.Straw.TURBO
            else -> throw IllegalArgumentException("Invalid Straw enum")
        }
    }
}