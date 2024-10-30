package br.com.nutriFAGOC.adapters.jdbc.http.security.exceptions


sealed class CredenciaisException(message: String) : Exception(message)

class CredenciaisInvalidasException() : CredenciaisException("Usuário ou senha invalida")