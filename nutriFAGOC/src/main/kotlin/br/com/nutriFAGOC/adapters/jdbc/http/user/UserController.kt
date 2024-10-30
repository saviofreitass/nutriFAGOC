package br.com.nutriFAGOC.adapters.jdbc.http.user

import br.com.nutriFAGOC.domain.food.Foods.usuario.User
import br.com.nutriFAGOC.application.Food.usuario.UserUpdateCommand
import br.com.nutriFAGOC.application.Food.usuario.UserCreateCommand
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

private const val UUID_REGEX = "[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}"

@RestController
@CrossOrigin(origins = arrayOf("*"))
class UserController(
    private val userHandler: UserHandler
) {
    @GetMapping("/users")
    fun findAll(): ResponseEntity<List<User>> {
        return userHandler.findAll()
    }

    @GetMapping("/users/{userId:$UUID_REGEX}")
    fun findById(@PathVariable userId: String) : ResponseEntity<User> {
        return userHandler.findById(userId)
    }

    @PostMapping("/users")
    fun insert(@RequestBody user: UserCreateCommand): ResponseEntity<User> {
        return userHandler.insert(user)
    }

    @PutMapping("/users/{userId:$UUID_REGEX}")
    fun update(@RequestBody user: UserUpdateCommand, @PathVariable userId: String): ResponseEntity<User> {
        return userHandler.update(user, userId)
    }

    @DeleteMapping("/users/{userId:$UUID_REGEX}")
    fun delete(@PathVariable userId: String): ResponseEntity<String> {
        return userHandler.delete(userId)
    }
}