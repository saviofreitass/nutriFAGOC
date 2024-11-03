package br.com.nutriFAGOC.adapters.jdbc.http.security

import br.com.nutriFAGOC.adapters.jdbc.http.security.exceptions.CredenciaisInvalidasException
import br.com.nutriFAGOC.adapters.jdbc.http.security.request.Credenciais
import br.com.nutriFAGOC.adapters.jdbc.http.security.response.Token
import br.com.nutriFAGOC.application.Food.usuario.EncoderPassword
import br.com.nutriFAGOC.application.Food.usuario.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = arrayOf("*"))
class LoginController(
    private val userService: UserService,
    private val encoderPassword: EncoderPassword
) {

    @PostMapping("/login")
    fun auth(@RequestBody credenciais: Credenciais): ResponseEntity<Token>{
        val usuario = userService.findByEmail(credenciais.email) ?: throw CredenciaisInvalidasException()

        if (!encoderPassword.matches(credenciais.senha, usuario.senha)){
            throw CredenciaisInvalidasException()
        }

        return ResponseEntity.ok(Token("Qualquer coisa"))
    }
}