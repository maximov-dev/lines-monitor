package error.model

import jakarta.validation.ConstraintViolation
import jakarta.validation.ConstraintViolationException
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
data class ErrorResponse(
    val errorCode: Int,
    val message: String
) {
    companion object {
        fun of(errorProperty: ErrorProperty) = ErrorResponse(
            errorProperty.errorCode(),
            errorProperty.message()
        )
        fun of(e: Exception): ErrorResponse {
            println(e)
            return ErrorResponse(
                errorCode = GlobalErrorCode.INTERNAL_SERVER_ERROR.errorCode(),
                message = GlobalErrorCode.INTERNAL_SERVER_ERROR.message()
            )
        }

        fun of(e: BindingResult): ValidationErrorResponse {
            val errorMap = HashMap<String, String?>()
            for (error: FieldError in e.fieldErrors) {
                errorMap[error.field] = error.defaultMessage
            }
            return ValidationErrorResponse(
                errorCode = GlobalErrorCode.BAD_REQUEST.errorCode(),
                fieldError = listOf(errorMap)
            )
        }
        fun of(e: ConstraintViolationException): ValidationErrorResponse {
            val errorMap = HashMap<String, String?>()
            for(error: ConstraintViolation<*> in e.constraintViolations) {
                val errorPropertyPath = error.propertyPath.toString()
                val index = errorPropertyPath.indexOf(".")
                val errorField = errorPropertyPath.substring(index.plus(1))
                errorMap[errorField] = error.message
            }
            return ValidationErrorResponse(
                errorCode = GlobalErrorCode.BAD_REQUEST.errorCode(),
                fieldError = listOf(errorMap)
            )
        }
    }
}
data class ValidationErrorResponse(
    val errorCode: Int,
    val fieldError: List<Map<String, String?>>
)