package br.com.nutriFAGOC.application.Food.usuario


import br.com.nutriFAGOC.application.Food.usuario.exception.UsuarioNaoEncontradaException
import br.com.nutriFAGOC.domain.food.Foods.usuario.User
import br.com.nutriFAGOC.domain.food.Foods.usuario.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val userRepository: UserRepository
) {

    fun findAll(): List<User> {
        return userRepository.findAll()
    }
    fun findById(userId: UUID): User {
        return userRepository.findById(userId) ?: throw UsuarioNaoEncontradaException(userId)
    }

    fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email)
    }


    fun insert(user: UserCreateCommand): User {
        val userDomain = user.toUser()
        userRepository.insert(user = userDomain)
        return findById(userDomain.id)
    }

    fun update(user: UserUpdateCommand, userId: UUID): User {
        userRepository.findById(userId = userId) ?: throw UsuarioNaoEncontradaException(userId)
        userRepository.update(user.toUser(userId))
        return findById(userId = userId)
    }

    fun delete(userId: UUID){
        userRepository.findById(userId = userId) ?: throw UsuarioNaoEncontradaException(userId)
        userRepository.delete(userId)
    }
}