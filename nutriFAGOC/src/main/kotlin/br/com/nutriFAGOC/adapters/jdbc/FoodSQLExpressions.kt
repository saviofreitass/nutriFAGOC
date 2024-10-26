package br.com.nutriFAGOC.adapters.jdbc

object FoodSQLExpressions {
    fun sqlSelectAll() = """
        SELECT
            id,
            categoria,
            numeroalimento,
            descricaoalimento,
            carboidrato,
            energiakcal,
            proteina,
            lipideos,
            colesterol,
            fibraalimentar,
            calcio,
            magnesio,
            fosforo,
            ferro,
            sodio,
            potassio,
            cobre,
            zinco, 
            vitaminac
        from alimentos
	
    """.trimIndent()

    fun sqlSelectById() = """
        SELECT
            id,
            categoria,
            numeroalimento,
            descricaoalimento,
            carboidrato,
            energiakcal,
            proteina,
            lipideos,
            colesterol,
            fibraalimentar,
            calcio,
            magnesio,
            fosforo,
            ferro,
            sodio,
            potassio,
            cobre,
            zinco, 
            vitaminac
        from alimentos
        WHERE alimentos.id = :id
    """.trimIndent()

    fun sqlInsertFood() = """
        INSERT INTO alimentos (
            id,
            categoria,
            numeroalimento,
            descricaoalimento,
            carboidrato,
            energiakcal,
            proteina,
            lipideos,
            colesterol,
            fibraalimentar,
            calcio,
            magnesio,
            fosforo,
            ferro,
            sodio,
            potassio,
            cobre,
            zinco, 
            vitaminac
        ) VALUES (
            :id,
            :categoria,
            :numeroalimento,
            :descricaoalimento,
            :carboidrato,
            :energiakcal,
            :proteina,
            :lipideos,
            :colesterol,
            :fibraalimentar,
            :calcio,
            :magnesio,
            :fosforo,
            :ferro,
            :sodio,
            :potassio,
            :cobre,
            :zinco, 
            :vitaminac
        )
    """.trimIndent()

    fun sqlUpdateFood() = """
    UPDATE alimentos
            set 
                categoria = :categoria,
                numeroalimento = :numeroalimento,
                descricaoalimento = :descricaoalimento,
                carboidrato = :carboidrato,
                energiakcal = :energiakcal,
                proteina = :proteina,
                lipideos = :lipideos,
                colesterol = :colesterol,
                fibraalimentar = :fibraalimentar,
                calcio = :calcio,
                magnesio = :magnesio,
                fosforo = :fosforo,
                ferro = :ferro,
                sodio = :sodio,
                potassio = :potassio,
                cobre = :cobre,
                zinco = :zinco, 
                vitaminac = :vitaminac         
        WHERE id = :id
    """.trimIndent()

    fun sqlDeleteFoodById()= """
        DELETE
        FROM alimentos
        WHERE id = :id
    """.trimIndent()
}