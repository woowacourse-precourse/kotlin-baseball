package baseball

interface GameProgressImpl {
    fun run()
}

abstract class GameProgress(
    private val participant1: Participant,
    private val participant2: Participant,
    private val messageMaker: StringMaker,
) : GameProgressImpl {
    override fun run() {
        println(messageMaker.initGameStartMessage())
        do {
            if (gameStart(participant1, participant2, messageMaker)) { //게임 성공하면 종료하고 나오면 됨.
                println(messageMaker.gameClearMessage())
            } else {
                println(messageMaker.gameFailedMessage())
            }
            println(messageMaker.restartGameQuestionMessage())
            val isRestart = isRestartGame(participant1) //게임 다시할지 말지...
        } while (isRestart)
    }

    protected abstract fun isRestartGame(participant: Participant): Boolean

    protected abstract fun gameStart(
        participant1: Participant,
        participant2: Participant,
        messageMaker: StringMaker,
    ): Boolean
}