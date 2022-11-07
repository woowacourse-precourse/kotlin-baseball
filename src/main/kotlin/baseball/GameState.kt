package baseball

sealed class GameResultType {
    data class NormalResult(
        val ball: Int,
        val strike: Int
    ) : GameResultType()
    object NothingResult : GameResultType()
    object CorrectResult : GameResultType()
}

sealed class ExceptionType {
    object GameException : ExceptionType()
    object RetryException : ExceptionType()
}