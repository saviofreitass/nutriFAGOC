package br.com.nutriFAGOC.application.Food

import br.com.nutriFAGOC.domain.food.Food
import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class FoodCreateCommand(

    val categoria: String,
    val numeroalimento: String,
    val descricaoalimento: String,
    val carboidrato: String,
    val energiakcal: String,
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
    val vitaminac: String,
)

@Serializable
data class FoodUpdateCommand(
    val id: UUID?,
    val categoria: String,
    val numeroalimento: String,
    val descricaoalimento: String,
    val carboidrato: String,
    val energiakcal: String,
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
    val vitaminac: String,
)

//metodo de extensão
fun FoodCreateCommand.toFood() = Food(

    categoria = categoria,
    numeroalimento = numeroalimento,
    descricaoalimento = descricaoalimento,
    carboidrato = carboidrato,
    energiakcal = energiakcal,
    proteina = proteina,
    lipideos = lipideos,
    colesterol = colesterol,
    fibraalimentar = fibraalimentar,
    calcio = calcio,
    magnesio = magnesio,
    fosforo = fosforo,
    ferro = ferro,
    sodio = sodio,
    potassio = potassio,
    cobre = cobre,
    zinco = zinco,
    vitaminac = vitaminac,
)

fun FoodUpdateCommand.toFood(id: UUID) = Food(
    id = id,
    categoria = categoria,
    numeroalimento = numeroalimento,
    descricaoalimento = descricaoalimento,
    carboidrato = carboidrato,
    energiakcal = energiakcal,
    proteina = proteina,
    lipideos = lipideos,
    colesterol = colesterol,
    fibraalimentar = fibraalimentar,
    calcio = calcio,
    magnesio = magnesio,
    fosforo = fosforo,
    ferro = ferro,
    sodio = sodio,
    potassio = potassio,
    cobre = cobre,
    zinco = zinco,
    vitaminac = vitaminac,
)