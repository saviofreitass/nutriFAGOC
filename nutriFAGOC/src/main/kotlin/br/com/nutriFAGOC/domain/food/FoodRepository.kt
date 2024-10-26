package br.com.nutriFAGOC.domain.food

import java.util.*

interface FoodRepository {
    fun findAll(): List<Food>

    fun findById(foodId: UUID): Food?

    fun insert(food: Food): Boolean

    fun update(food: Food): Boolean

    fun delete(foodId: UUID): Boolean
}