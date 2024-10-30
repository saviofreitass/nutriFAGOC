package br.com.nutriFAGOC.application.Food.usuario.exception

import java.util.*

sealed class UserException(massage: String) : Exception(massage) {
    abstract val userId: UUID?
}

data class UsuarioNaoEncontradaException(
    override val userId: UUID?
): UserException("Usuario $userId não encontrado")