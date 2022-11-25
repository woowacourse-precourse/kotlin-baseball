package baseball

import camp.nextstep.edu.missionutils.Console

const val INPUT_LENGTH_STANDARD = 3
const val GAME_CLEAR = 3
const val USER_WANT_PLAY_AGAIN = 1
const val USER_DONT_WANT_PLAY_AGAIN = 2
const val MIN_NUMBER = 1
const val MAX_NUMBER = 9

fun main() {
    PrintForm().printPlayGame()
    startGame()

}

private fun startGame() {
    val answerList = RandomInput().getRandomNumberList()
    while (true) {
        if (Compare().checkBallAndStrike(UserInput().getUserInput(), answerList)) {
            checkWantPlayAgain()
            break
        }
    }
}

private fun checkWantPlayAgain() {
    while (true) {
        val userRetryInput = compareRetryInput()
        if (userRetryInput?.toInt() == USER_WANT_PLAY_AGAIN) {
            startGame()
            break
        }
    }
}

private fun compareRetryInput(): String? {
    PrintForm().printWannaRetry()
    var userInput: String = Console.readLine()
    return if (Regex().checkInputIsNumber(userInput) && userInput.toInt() in USER_WANT_PLAY_AGAIN..USER_DONT_WANT_PLAY_AGAIN) {
        userInput
    } else {
        PrintForm().printWrongInput()
        null
    }
}