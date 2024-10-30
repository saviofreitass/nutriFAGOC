package br.com.nutriFAGOC.adapters.jdbc.http.food

import br.com.nutriFAGOC.application.Food.food.FoodCreateCommand
import br.com.nutriFAGOC.application.Food.food.FoodService
import br.com.nutriFAGOC.application.Food.food.FoodUpdateCommand
import br.com.nutriFAGOC.domain.food.Foods.food.Food
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class FoodHandler(
    private val foodService: FoodService
) {

    fun findAll(): ResponseEntity<List<Food>> {
        val food = foodService.findAll()
        return ResponseEntity.ok(food)
    }

    fun findById(foodId: String): ResponseEntity<Food> {
        val food = foodService.findById(UUID.fromString(foodId))
        return ResponseEntity.ok(food)
    }

    fun insert(foodCreateCommand: FoodCreateCommand): ResponseEntity<Food> {
        val food = foodService.insert(foodCreateCommand)
        return ResponseEntity.status(HttpStatus.CREATED).body(food)
    }

    fun update(foodUpdateCommand: FoodUpdateCommand, foodId: String): ResponseEntity<Food> {
        val food = foodService.update(foodUpdateCommand, UUID.fromString(foodId))
        return ResponseEntity.ok(food)
    }

    fun delete(foodId: String): ResponseEntity<String> {
        foodService.delete(foodId = UUID.fromString(foodId))
        return ResponseEntity.noContent().build()
    }
}