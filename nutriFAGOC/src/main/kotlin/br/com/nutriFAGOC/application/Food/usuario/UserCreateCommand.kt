package br.com.nutriFAGOC.application.Food.usuario

import br.com.nutriFAGOC.domain.food.Foods.usuario.User
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class UserCreateCommand(

    val nome: String,
    val email: String,
    val senha: String,
)

@Serializable
data class UserUpdateCommand(
    val id: UUID?,
    val nome: String,
    val email: String,
    val senha: String,
)

fun UserCreateCommand.toUser() = User(
    nome = nome,
    email = email,
    senha = senha,
)

fun UserUpdateCommand.toUser(id: UUID) = User(
    id = id,
    nome = nome,
    email = email,
    senha = senha,
)