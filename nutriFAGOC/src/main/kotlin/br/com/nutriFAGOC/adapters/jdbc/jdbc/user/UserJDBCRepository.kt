package br.com.nutriFAGOC.adapters.jdbc.jdbc.user


import br.com.nutriFAGOC.adapters.jdbc.ecrypt.PasswordBcryptEncoder
import br.com.nutriFAGOC.adapters.jdbc.jdbc.user.UserSQLExpressions.sqlDeleteUserById
import br.com.nutriFAGOC.adapters.jdbc.jdbc.user.UserSQLExpressions.sqlInsertUser
import br.com.nutriFAGOC.adapters.jdbc.jdbc.user.UserSQLExpressions.sqlSelectAll
import br.com.nutriFAGOC.adapters.jdbc.jdbc.user.UserSQLExpressions.sqlSelectByEmail
import br.com.nutriFAGOC.adapters.jdbc.jdbc.user.UserSQLExpressions.sqlSelectById
import br.com.nutriFAGOC.adapters.jdbc.jdbc.user.UserSQLExpressions.sqlUpdateUser
import br.com.nutriFAGOC.domain.food.Foods.usuario.User
import br.com.nutriFAGOC.domain.food.Foods.usuario.UserRepository
import mu.KotlinLogging
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class UserJDBCRepository(
    private val passwordBcryptEncoder: PasswordBcryptEncoder,
    private val db: NamedParameterJdbcOperations
) : UserRepository {
    private companion object{
        val LOGGER = KotlinLogging.logger { }
    }

    override fun findAll(): List<User> {
        val user = try {
            db.query(sqlSelectAll(), rowMapper())
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao consultar os usuarios: ${ex.message}" }
            throw ex
        }
        user.forEach { it.senha = "" }
        return user
    }

    override fun findById(userId: UUID): User? {

        val user = try {
            val params = MapSqlParameterSource("id", userId)
            db.query(sqlSelectById(), params, rowMapper()).firstOrNull()
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao consultar o usuario: ${ex.message}" }
            throw ex
        }
        user?.senha = ""
        return user
    }

    override fun findByEmail(email: String): User? {

        val user = try {
            val params = MapSqlParameterSource("email", email)
            db.query(sqlSelectByEmail(), params, rowMapper()).firstOrNull()
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao consultar o usuario: ${ex.message}" }
            throw ex
        }
        return user
    }


    override fun insert(user: User): Boolean {
        try {
            val params = parametros(user)
            val linhasAfetadas = db.update(sqlInsertUser(), params)
            return linhasAfetadas > 0
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao inserir o usuario: ${ex.message}" }
            throw ex
        }
    }


    override fun update(user: User): Boolean {
        try {
            val params = parametros(user)
            val linhasAfetadas = db.update(sqlUpdateUser(), params)
            return linhasAfetadas > 0
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao atualizar o usuario: ${ex.message}" }
            throw ex
        }
    }

    override fun delete(userId: UUID): Boolean {
        try {
            val params = MapSqlParameterSource("id", userId)
            val linhasExcluidas = db.update(sqlDeleteUserById(), params)
            return linhasExcluidas == 1
        }catch (ex: Exception){
            LOGGER.error { "Houve um erro ao excluir o usuario: ${ex.message}" }
            throw ex
        }
    }


    private fun rowMapper() = RowMapper<User>{ rs, _ ->
        val userId = UUID.fromString(rs.getString("id"))
        User(
            id = userId,
            nome = rs.getString("nome"),
            email = rs.getString("email"),
            senha = rs.getString("senha")
        )
    }

    private fun parametros(user: User): MapSqlParameterSource {
        val params = MapSqlParameterSource()
        params.addValue("id", user.id)
        params.addValue("nome", user.nome)
        params.addValue("email", user.email)
        val senhaHasheada = passwordBcryptEncoder.encode(user.senha)
        params.addValue("senha", senhaHasheada)

        return params
    }
}