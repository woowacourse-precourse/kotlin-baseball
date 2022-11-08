package baseball

import baseball.GameState.ONGOING_STATE
import baseball.InputState.ONGOING_INPUT
import baseball.InputState.RESTART_INPUT
import baseball.NumberBaseBallGamePhrases.ONGOING_INPUT_PHRASE
import baseball.NumberBaseBallGamePhrases.START_PHRASE
import java.util.regex.Pattern

fun main() {
    printStartGameString()
    val gameState = ONGOING_STATE
    val randomNumberList = getRandomNumberList(3)
    val inputState = ONGOING_INPUT

    while (gameState == ONGOING_STATE) {
        lateinit var stepUserInput: String

        when (inputState) {
            ONGOING_INPUT -> {
                print(ONGOING_INPUT_PHRASE)
                stepUserInput = camp.nextstep.edu.missionutils.Console.readLine()
                if (!checkInputLength(stepUserInput, 3)) throw IllegalArgumentException("입력된 숫자의 길이가 적절치 않습니다.")
                if (!isInputTypeNumber(stepUserInput)) throw IllegalArgumentException("입력이 숫자타입이 아닙니다")
                if (!checkDuplicatePartInInput(stepUserInput)) throw IllegalArgumentException("중복된 숫자가 입력되었습니다.")
            }
            RESTART_INPUT -> {
            }
        }
    }
}

private fun printStartGameString() {
    println(START_PHRASE)
}

private fun getRandomNumberList(listLength: Int): MutableList<Int> {
    val candidateNumberList = mutableListOf<Int>().apply { addAll(1..9) }
    val randomNumberList = mutableListOf<Int>()
    for (i in 1..listLength) {
        val stageNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInList(candidateNumberList)
        candidateNumberList.remove(stageNumber)
        randomNumberList.add(stageNumber)
    }

    return randomNumberList
}

private fun isInputTypeNumber(userInput: String): Boolean = Pattern.matches("^[0-9]+$", userInput)

private fun checkInputLength(userInput: String, expectedLength: Int): Boolean = userInput.length == expectedLength

private fun checkDuplicatePartInInput(userInput: String): Boolean = userInput.length == userInput.toSet().size

private fun checkValidateRestartInput(userInput: String): Boolean = userInput == "1" || userInput == "2"
