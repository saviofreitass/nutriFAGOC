package br.com.nutriFAGOC.adapters.jdbc.http.user


import br.com.nutriFAGOC.application.Food.usuario.UserService
import br.com.nutriFAGOC.application.Food.usuario.UserUpdateCommand
import br.com.nutriFAGOC.application.Food.usuario.UserCreateCommand
import br.com.nutriFAGOC.domain.food.Foods.usuario.User
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserHandler(
    private val userService: UserService
) {

    fun findAll(): ResponseEntity<List<User>> {
        val user = userService.findAll()
        return ResponseEntity.ok(user)
    }

    fun findById(userId: String): ResponseEntity<User> {
        val user = userService.findById(UUID.fromString(userId))
        return ResponseEntity.ok(user)
    }

    fun insert(userCreateCommand: UserCreateCommand): ResponseEntity<User> {
        val user = userService.insert(userCreateCommand)
        return ResponseEntity.status(HttpStatus.CREATED).body(user)
    }

    fun update(userUpdateCommand: UserUpdateCommand, userId: String): ResponseEntity<User> {
        val user = userService.update(userUpdateCommand, UUID.fromString(userId))
        return ResponseEntity.ok(user)
    }

    fun delete(userId: String): ResponseEntity<String> {
        userService.delete(userId = UUID.fromString(userId))
        return ResponseEntity.noContent().build()
    }
}