package br.com.nutriFAGOC.adapters.jdbc.ecrypt
import br.com.nutriFAGOC.application.Food.usuario.EncoderPassword
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component

@Component
class PasswordBcryptEncoder (
    private val passWordEnconder: PasswordEncoder,
) : EncoderPassword{
    override fun encode(senha: String): String {
        return passWordEnconder.encode(senha)
    }

    override fun matches(rawPassword: String, encoderPassword: String): Boolean {
        return passWordEnconder.matches(rawPassword, encoderPassword)
    }
}