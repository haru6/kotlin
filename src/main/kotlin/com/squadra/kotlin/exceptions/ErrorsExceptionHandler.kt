package com.squadra.kotlin.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@ControllerAdvice
class ErrorsExceptionHandler {

    @ExceptionHandler(BusinessException::class)
    fun ProdutoNaoEncontrado(servletRequest: HttpServletRequest, servletResponse: HttpServletResponse, exception: Exception):
        ResponseEntity<ErrorsException>{
        return ResponseEntity(ErrorsException(exception.message !!), HttpStatus.NOT_FOUND)
    }
}