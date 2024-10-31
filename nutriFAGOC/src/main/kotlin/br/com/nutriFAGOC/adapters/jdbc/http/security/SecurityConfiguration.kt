package br.com.nutriFAGOC.adapters.jdbc.http.security

import br.com.nutriFAGOC.adapters.jdbc.http.security.exceptions.CustomEntryPoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfiguration {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain{
        return http.authorizeHttpRequests {
           // it.requestMatchers("/login/**")
            it.anyRequest().permitAll()
        }.csrf {
            it.disable()
        }.exceptionHandling{
            it.authenticationEntryPoint(CustomEntryPoint())

        }
            .build()
    }
}