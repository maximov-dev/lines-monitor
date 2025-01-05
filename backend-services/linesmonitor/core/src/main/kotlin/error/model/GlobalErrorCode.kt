package error.model

enum class GlobalErrorCode(
    private val errorCode: Int,
    private val message: String
) : ErrorProperty {
    BAD_REQUEST(400, "Bad Request"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    override fun errorCode(): Int = errorCode
    override fun message(): String = message
}
