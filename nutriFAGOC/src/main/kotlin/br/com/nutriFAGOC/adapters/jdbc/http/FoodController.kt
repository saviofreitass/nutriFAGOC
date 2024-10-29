package br.com.nutriFAGOC.adapters.jdbc.http

import br.com.nutriFAGOC.application.Food.FoodCreateCommand
import br.com.nutriFAGOC.application.Food.FoodUpdateCommand
import br.com.nutriFAGOC.domain.food.Food
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

private const val UUID_REGEX = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}"

@RestController
@CrossOrigin(origins = arrayOf("*"))
class FoodController(
    private val foodHandler: FoodHandler
) {
    @GetMapping("/foods")
    fun findAll(): ResponseEntity<List<Food>> {
        return foodHandler.findAll()
    }

    @GetMapping("/foods/{foodId:$UUID_REGEX}")
    fun findById(@PathVariable foodId: String) : ResponseEntity<Food> {
        return foodHandler.findById(foodId)
    }

    @PostMapping("/foods")
    fun insert(@RequestBody food: FoodCreateCommand): ResponseEntity<Food> {
        return foodHandler.insert(food)
    }

    @PutMapping("/foods/{foodId:$UUID_REGEX}")
    fun update(@RequestBody food: FoodUpdateCommand, @PathVariable foodId: String): ResponseEntity<Food> {
        return foodHandler.update(food, foodId)
    }

    @DeleteMapping("/foods/{foodId:$UUID_REGEX}")
    fun delete(@PathVariable foodId: String): ResponseEntity<String> {
        return foodHandler.delete(foodId)
    }
}