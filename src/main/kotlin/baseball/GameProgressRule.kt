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

class BaseBallGameRule(
    private val user: Participant,
    private val computer: Participant,
    private val messageMaker: StringMaker,
    private val checkParser: InputValidCheckAndConverter,
) : GameProgress(user, computer, messageMaker) {

    override fun isRestartGame(user: Participant): Boolean {
        val userInput = user.input() as String
        val isRestart =
            checkParser.inputValidCheckAndConvert(BaseballGameInputConverter.INPUT_RESTART_GAME, userInput) as Int
        return isRestart == 1
    }

    override fun gameStart(user: Participant, computer: Participant, messageMaker: StringMaker): Boolean {
        val computerNumbers = computer.input() as List<Int>
        while (true) {
            print(messageMaker.inputForEachRoundMessage())
            val userInput = user.input() as String
            val userSelectNumbers = checkParser.inputValidCheckAndConvert(BaseballGameInputConverter.INPUT_CUR_ROUND,
                userInput)!!
            val resultCurRound = messageMaker.resultCurRound(userSelectNumbers, computerNumbers)
            println(resultCurRound)
            if (resultCurRound == BaseballStringMaker.END_CONDITION_MESSAGE) break
        }
        return true
    }

}