package br.com.nutriFAGOC.adapters.jdbc.jdbc.food

import br.com.nutriFAGOC.adapters.jdbc.jdbc.food.FoodSQLExpressions.sqlDeleteFoodById
import br.com.nutriFAGOC.adapters.jdbc.jdbc.food.FoodSQLExpressions.sqlInsertFood
import br.com.nutriFAGOC.adapters.jdbc.jdbc.food.FoodSQLExpressions.sqlSelectAll
import br.com.nutriFAGOC.adapters.jdbc.jdbc.food.FoodSQLExpressions.sqlSelectById
import br.com.nutriFAGOC.adapters.jdbc.jdbc.food.FoodSQLExpressions.sqlUpdateFood
import br.com.nutriFAGOC.domain.food.Foods.food.Food
import br.com.nutriFAGOC.domain.food.Foods.food.FoodRepository
import mu.KotlinLogging
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class foodJDBCRepository(
    private val db: NamedParameterJdbcOperations
) : FoodRepository {
    private companion object{
        val LOGGER = KotlinLogging.logger { }
    }

    override fun findAll(): List<Food> {
        val food = try {
            db.query(sqlSelectAll(), rowMapper())
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao consultar as tarefas: ${ex.message}" }
            throw ex
        }
        return food
    }

    override fun findById(foodId: UUID): Food? {

        val food = try {
            val params = MapSqlParameterSource("id", foodId)
            db.query(sqlSelectById(), params, rowMapper()).firstOrNull()
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao consultar a alimentos: ${ex.message}" }
            throw ex
        }
        return food
    }


    override fun insert(food: Food): Boolean {
        try {
            val params = parametros(food)
            val linhasAfetadas = db.update(sqlInsertFood(), params)
            return linhasAfetadas > 0
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao inserir o produto: ${ex.message}" }
            throw ex
        }
    }


    override fun update(food: Food): Boolean {
        try {
            val params = parametros(food)
            val linhasAfetadas = db.update(sqlUpdateFood(), params)
            return linhasAfetadas > 0
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao atualizar o produto: ${ex.message}" }
            throw ex
        }
    }

    override fun delete(foodId: UUID): Boolean {
        try {
            val params = MapSqlParameterSource("id", foodId)
            val linhasExcluidas = db.update(sqlDeleteFoodById(), params)
            return linhasExcluidas == 1
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao excluir o produto: ${ex.message}" }
            throw ex
        }
    }


    private fun rowMapper() = RowMapper<Food>{ rs, _ ->
        val foodID = UUID.fromString(rs.getString("id"))
        Food(
            id = foodID,
            categoria = rs.getString("categoria"),
            numeroalimento = rs.getString("numeroalimento"),
            descricaoalimento = rs.getString("descricaoalimento"),
            carboidrato = rs.getString("carboidrato"),
            energiakcal = rs.getString("energiakcal"),
            energiakj = rs.getString("energiakj"),
            proteina = rs.getString("proteina"),
            lipideos = rs.getString("lipideos"),
            colesterol = rs.getString("colesterol"),
            fibraalimentar = rs.getString("fibraalimentar"),
            calcio = rs.getString("calcio"),
            magnesio = rs.getString("magnesio"),
            fosforo = rs.getString("fosforo"),
            ferro = rs.getString("ferro"),
            sodio = rs.getString("sodio"),
            potassio = rs.getString("potassio"),
            cobre = rs.getString("cobre"),
            zinco = rs.getString("zinco"),
            vitaminac = rs.getString("vitaminac")
        )
    }

    private fun parametros(food: Food): MapSqlParameterSource {
        val params = MapSqlParameterSource()
        params.addValue("id", food.id)
        params.addValue("categoria", food.categoria)
        params.addValue("numeroalimento", food.numeroalimento)
        params.addValue("descricaoalimento", food.descricaoalimento)
        params.addValue("carboidrato", food.carboidrato)
        params.addValue("energiakcal", food.energiakcal)
        params.addValue("energiakj", food.energiakj)
        params.addValue("proteina", food.proteina)
        params.addValue("lipideos", food.lipideos)
        params.addValue("colesterol", food.colesterol)
        params.addValue("fibraalimentar", food.fibraalimentar)
        params.addValue("calcio", food.calcio)
        params.addValue("magnesio", food.magnesio)
        params.addValue("fosforo", food.fosforo)
        params.addValue("ferro", food.ferro)
        params.addValue("sodio", food.sodio)
        params.addValue("potassio", food.potassio)
        params.addValue("cobre", food.cobre)
        params.addValue("zinco", food.zinco)
        params.addValue("vitaminac", food.vitaminac)
        return params
    }
}