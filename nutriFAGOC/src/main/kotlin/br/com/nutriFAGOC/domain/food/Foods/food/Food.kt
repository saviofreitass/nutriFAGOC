package br.com.nutriFAGOC.domain.food.Foods.food

import java.util.*

class Food (
    val id: UUID = UUID.randomUUID(),
    val categoria: String,
    val numeroalimento: String,
    val descricaoalimento: String,
    val carboidrato: String,
    val energiakcal: String,
    val energiakj: String,
    val proteina: String,
    val lipideos: String,
    val colesterol: String,
    val fibraalimentar: String,
    val calcio: String,
    val magnesio: String,
    val fosforo: String,
    val ferro: String,
    val sodio: String,
    val potassio: String,
    val cobre: String,
    val zinco: String,
    val vitaminac: String
)

