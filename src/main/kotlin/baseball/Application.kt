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
    while(true) {
        if(Compare().checkBallAndStrike(UserInput().getUserInput(), answerList)) {
            checkWantPlayAgain()
            break
        }
    }
}

private fun checkWantPlayAgain() {
    var userInput: String
    while (true) {
        PrintForm().printWannaRetry()
        userInput = Console.readLine()
        if (!Regex().checkInputIsNumber(userInput)) {
            PrintForm().printWrongInput()
            return
        }
        if (userInput.toInt() in USER_WANT_PLAY_AGAIN..USER_DONT_WANT_PLAY_AGAIN) {
            break
        }
        PrintForm().printWrongInput()
    }
    if (userInput.toInt() == USER_WANT_PLAY_AGAIN) {
        startGame()
    }
}