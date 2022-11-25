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
        if(checkBallAndStrike(UserInput().getUserInput(), answerList)) {
            checkWantPlayAgain()
            break
        }
    }
}


private fun checkBallAndStrike(userInputList: List<Int>, answerList: List<Int>): Boolean {
    var strikeCount = 0
    var ballCount = 0

    for (userInputPosition in userInputList.indices) {
        ballCount += checkBallCount(userInputList[userInputPosition], userInputPosition, answerList)
        strikeCount += checkStrikeCount(userInputList[userInputPosition], userInputPosition, answerList)
    }
    printResult(strikeCount, ballCount)
    return strikeCount == GAME_CLEAR
}

private fun checkBallCount(userInputEach: Int, userInputPosition: Int, answerList: List<Int>): Int {
    for (answerPosition in answerList.indices) {
        if (answerList[answerPosition] == userInputEach && userInputPosition != answerPosition) {
            return 1
        }
    }
    return 0
}

private fun checkStrikeCount(userInputEach: Int, userInputPosition: Int, answerList: List<Int>): Int {
    for (answerPosition in answerList.indices) {
        if (answerList[answerPosition] == userInputEach && userInputPosition == answerPosition) {
            return 1
        }
    }
    return 0
}

private fun printResult(strikeCount: Int, ballCount: Int) {
    if (strikeCount == 0 && ballCount == 0) {
        PrintForm().printNothing()
    }
    if (strikeCount == GAME_CLEAR) {
        PrintForm().printWhen3Strike(strikeCount)
    }
    if (strikeCount in 1 until INPUT_LENGTH_STANDARD && ballCount in 1 until INPUT_LENGTH_STANDARD) {
        PrintForm().printStrikeAndBall(ballCount, strikeCount)
    }
    if (strikeCount in 1 until INPUT_LENGTH_STANDARD && ballCount == 0) {
        PrintForm().printOnlyStrike(strikeCount)
    }
    if (strikeCount == 0 && ballCount in 1..INPUT_LENGTH_STANDARD) {
        PrintForm().printOnlyBall(ballCount)
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