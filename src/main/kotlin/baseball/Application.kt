package baseball

import baseball.GameState.ONGOING_STATE
import baseball.NumberBaseBallGamePhrases.START_PHRASE
import java.util.regex.Pattern

fun main() {
    printStartGameString()
    val gameState = ONGOING_STATE
    val randomNumberList = getRandomNumberList(3)

    while (gameState == ONGOING_STATE) {
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


