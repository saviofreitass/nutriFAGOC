package br.com.nutriFAGOC.adapters.jdbc.http.security.response

import kotlinx.serialization.Serializable

@Serializable
data class Token (
    val acessToken: String
)