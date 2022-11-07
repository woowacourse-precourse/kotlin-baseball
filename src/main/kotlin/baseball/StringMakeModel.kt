package baseball

interface StringMaker {
    fun initGameStartMessage(): String
    fun inputForEachRoundMessage(): String
    fun resultCurRound(user: Any, enemy: Any): String
    fun gameClearMessage(): String
    fun gameFailedMessage(): String
    fun restartGameQuestionMessage(): String
}