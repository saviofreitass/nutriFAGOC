package br.com.nutriFAGOC.domain.food.Foods.usuario;

import java.util.UUID;
import java.util.*

class User (
    val id: UUID = UUID.randomUUID(),
    val nome: String,
    val email: String,
    var senha: String
)
