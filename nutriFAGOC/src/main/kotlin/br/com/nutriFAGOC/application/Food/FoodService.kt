package br.com.nutriFAGOC.application.Food

import br.com.nutriFAGOC.application.Food.exception.AlimentoNaoEncontradaException
import br.com.nutriFAGOC.domain.food.Food
import br.com.nutriFAGOC.domain.food.FoodRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class FoodService(
    private val foodRepository: FoodRepository
) {

    fun findAll(): List<Food> {
        return foodRepository.findAll()
    }
    fun findById(foodId: UUID): Food{
        return foodRepository.findById(foodId) ?: throw AlimentoNaoEncontradaException(foodId)
    }
    fun insert(food: FoodCreateCommand): Food{
        val foodDomain = food.toFood()
        foodRepository.insert(food = foodDomain)
        return findById(foodDomain.id)
    }

    fun update(food: FoodUpdateCommand, foodId: UUID): Food {
        foodRepository.findById(foodId = foodId) ?: throw AlimentoNaoEncontradaException(foodId)
        foodRepository.update(food.toFood(foodId))
        return findById(foodId = foodId)
    }

    fun delete(foodId: UUID){
        foodRepository.findById(foodId = foodId) ?: throw AlimentoNaoEncontradaException(foodId)
        foodRepository.delete(foodId)
    }
}