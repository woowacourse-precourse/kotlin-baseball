package baseball

class Game {
    companion object {
        var count: Int = 0
    }

    private val userNumber = UserNumber()
    private val message = ConsoleMessage()

    fun playBaseball(): Boolean {
        var success: Boolean
        val endTheGame: Boolean
        startBaseball()
        val computerRandomNumber = ComputerNumber().makeComputerBaseball()
        while (true) {
            message.inputMessage()
            success = inputJudge(userNumber.inputNum(), computerRandomNumber)
            if (success) {
                endTheGame = restartOrEndBaseball()
                return endTheGame
            }
        }
    }

    private fun inputJudge(inputNumber: String, computerRandomNumber: List<Int>): Boolean {
        if (InputValidation(inputNumber).inputNumberExceptionCheck()) {
            val inputNumberToList = inputNumber.map { it.digitToInt() }.toList()
            val strikeOrBall = Judgement(inputNumberToList, computerRandomNumber).judgeTheBall()
            successOrNot(strikeOrBall)
            if (strikeOrBall == listOf(3, 0)) {
                return true
            }
        }
        return false
    }

    fun successOrNot(strikeOrBall: MutableList<Int>) {
        if (strikeOrBall[0] == 3 && strikeOrBall[1] == 0) {
            message.strikeMessage(strikeOrBall[0])
        }
        if (strikeOrBall[0] == 0 && strikeOrBall[1] == 0) {
            message.nothingMessage()
        }
        if (strikeOrBall[1] != 0 && strikeOrBall[0] != 0) {
            message.ballMessage(strikeOrBall[1])
            message.strikeMessage(strikeOrBall[0])
        }
        if (strikeOrBall[1] == 0 && strikeOrBall[0] != 0) {
            if (strikeOrBall[0] != 3) {
                message.strikeMessage(strikeOrBall[0])
            }
        }
        if (strikeOrBall[0] == 0 && strikeOrBall[1] != 0) {
            message.ballMessage(strikeOrBall[1])
            message.printLineBreak()
        }
    }

    fun restartOrEndBaseball(): Boolean {
        message.successRestartMessage()
        val inputNumber = userNumber.inputNum()
        if (InputValidation(inputNumber).restartNumberExceptionCheck()) {
            if (inputNumber.toInt() == 1) {
                count += 1
                return false
            }
            if (inputNumber.toInt() == 2) {
                return true
            }
        }
        return false
    }

    fun startBaseball() {
        if (count == 0) {
            message.startMessage()
        }
    }

}