package com.yield.utils

import org.springframework.boot.logging.LogLevel
import org.springframework.http.HttpStatus

enum class ErrorType(val status: HttpStatus, val code: ErrorCode, val message: String, val logLevel: LogLevel) {
    DEFAULT_ERROR(
       status = HttpStatus.INTERNAL_SERVER_ERROR,
        code = ErrorCode.E500,
        message = "An unexpected error has occurred.",
        logLevel = LogLevel.ERROR
    ),
}

data class ErrorMessage private constructor(
    val code: String,
    val message: String,
    val data: Any? = null,
) {
    constructor(errorType: ErrorType, data: Any? = null) : this(
        code = errorType.code.name,
        message = errorType.message,
        data = data,
    )
}

enum class ErrorCode {
    E500,
}
