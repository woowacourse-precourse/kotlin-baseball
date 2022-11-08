package baseball.utils

sealed class ResultType {
    data class NormalResult(
        val ball: Int,
        val strike: Int
    ) : ResultType()
    object NothingResult : ResultType()
    object CorrectResult : ResultType()
}

sealed class ExceptionType {
    object GameException : ExceptionType()
    object RetryException : ExceptionType()
}