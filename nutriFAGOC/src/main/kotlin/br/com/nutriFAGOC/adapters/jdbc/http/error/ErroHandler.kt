package br.com.nutriFAGOC.adapters.jdbc.http.error

import br.com.nutriFAGOC.application.Food.food.exception.AlimentoNaoEncontradaException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import java.util.*

@ControllerAdvice
class ErrorHandler {

    @ExceptionHandler(Exception::class)
    fun handlerException(ex: Exception): ResponseEntity<ErrorResponse> {
        return ex.toServerResponse()
    }
}

// Logger
private val LOGGER = LoggerFactory.getLogger(ErrorHandler::class.java)

private fun Throwable.toResponse(): Pair<HttpStatus, ErrorResponse> =
    when (this) {
        is AlimentoNaoEncontradaException -> toResponse(
            id = this.foodId,
            statusCode = HttpStatus.NOT_FOUND
        )
        else -> toResponse(
            statusCode = HttpStatus.BAD_REQUEST
        )
    }

private fun Throwable.toResponse(
    id: UUID? = null,
    statusCode: HttpStatus,
    message: String = this.message ?: ""
): Pair<HttpStatus, ErrorResponse> {
    val response = ErrorResponse(
        id = id,
        message = message
    )
    val fullMessage = "[${statusCode.value()}] [${this.javaClass.simpleName}] $message"
    if (statusCode.is5xxServerError) {
        LOGGER.error(fullMessage, this)
    } else {
        LOGGER.warn(fullMessage)
    }
    return statusCode to response
}

fun Throwable.toServerResponse(): ResponseEntity<ErrorResponse> {
    val (statusCode, response) = toResponse()
    return ResponseEntity.status(statusCode).body(response)
}
