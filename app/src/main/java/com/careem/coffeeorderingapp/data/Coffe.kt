package com.careem.coffeeorderingapp.data

data class Coffe(var coffe: CoffeType, var coffeSize: CoffeSize) {

    fun calculateTotalPrice(): Double {
        return coffe.typePrice + (coffe.typePrice * 0.025 * coffeSize.value)
    }

    fun updateCoffeType(newType: CoffeType) {
        coffe = newType
    }

    fun updateCoffeSize(coffeSize: CoffeSize) {
        this.coffeSize = coffeSize
    }
}
