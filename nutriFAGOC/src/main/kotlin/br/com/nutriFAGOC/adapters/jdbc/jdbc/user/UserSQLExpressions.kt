package br.com.nutriFAGOC.adapters.jdbc.jdbc.user

object UserSQLExpressions {
    fun sqlSelectAll() = """
        SELECT
            id,
            nome,
            email,
            senha
        from usuarios
	
    """.trimIndent()

    fun sqlSelectById() = """
        SELECT
            id,
            nome,
            email,
            senha
        from usuarios
        WHERE usuarios.id = :id
    """.trimIndent()

    fun sqlInsertUser() = """
        INSERT INTO usuarios (
            id,
            nome,
            email,
            senha
        ) VALUES (
            :id,
            :nome,
            :email,
            :senha
        )
    """.trimIndent()

    fun sqlUpdateUser() = """
    UPDATE usuarios
            set 
                nome = :nome,
                email = :email,
                senha = :senha         
        WHERE id = :id
    """.trimIndent()

    fun sqlDeleteUserById()= """
        DELETE
        FROM usuarios
        WHERE id = :id
    """.trimIndent()
}