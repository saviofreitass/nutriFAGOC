package br.com.nutriFAGOC.application.Food.exception

import java.util.*

sealed class FoodException(massage: String) : Exception(massage) {
    abstract val foodId: UUID?
}

data class AlimentoNaoEncontradaException(
    override val foodId: UUID?
): FoodException("Alimento $foodId não encontrado")