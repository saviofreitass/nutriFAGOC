package br.com.nutriFAGOC.application.Food.usuario

interface EncoderPassword {
    fun encode(senha: String): String

    fun matches(rawPassword: String, encoderPassword: String): Boolean
}