package br.com.nutriFAGOC.domain.food.Foods.usuario

import br.com.nutriFAGOC.domain.food.Foods.food.Food
import java.util.*

interface UserRepository {
    fun findAll(): List<User>

    fun findById(userId: UUID): User?

    fun insert(user: User): Boolean

    fun update(user: User): Boolean

    fun delete(userId: UUID): Boolean

    fun findByEmail(email: String): User?
}