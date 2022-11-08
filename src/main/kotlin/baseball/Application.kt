package baseball

import baseball.GameState.END_STATE
import baseball.GameState.ONGOING_STATE
import baseball.InputState.ONGOING_INPUT
import baseball.InputState.RESTART_INPUT
import baseball.NumberBaseBallGamePhrases.BALL_PHRASE
import baseball.NumberBaseBallGamePhrases.NOTHING_PHRASE
import baseball.NumberBaseBallGamePhrases.ONGOING_INPUT_PHRASE
import baseball.NumberBaseBallGamePhrases.RESTART_INPUT_PHRASE
import baseball.NumberBaseBallGamePhrases.START_PHRASE
import baseball.NumberBaseBallGamePhrases.STRIKE_PHRASE
import baseball.NumberBaseBallGamePhrases.THREE_STRIKE_PHRASE
import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import java.util.regex.Pattern

const val BALL = 0
const val STRIKE = 1

fun main() {
    printStartGamePhrase()
    var gameState = ONGOING_STATE
    var randomNumberString = getRandomNumberString(3)
    var inputState = ONGOING_INPUT
    lateinit var processedPairByCalcIsNothing: Pair<MutableList<Int>, Boolean>

    while (gameState == ONGOING_STATE) {
        lateinit var stepUserInput: String
        var stepScoreList = mutableListOf(0, 0)

        when (inputState) {
            ONGOING_INPUT -> {
                printOngoingInputPhrase()
                stepUserInput = readLine()
                checkAppropriateOngoingInput(stepUserInput)
            }
            RESTART_INPUT -> {
                printRestartInputPhrase()
                val gameStateInput = readLine()
                checkAppropriateRestartInput(gameStateInput)
                gameState = getGameState(gameStateInput)
                randomNumberString = getRandomNumberString(3)
                inputState = ONGOING_INPUT
                continue
            }
        }

        processedPairByCalcIsNothing = calcIsNothing(stepUserInput, randomNumberString)
        if (processedPairByCalcIsNothing.second) continue

        stepScoreList = calcStepScoreList(stepUserInput, randomNumberString, processedPairByCalcIsNothing.first)

        printScore(stepScoreList)

        if (checkThreeStrike(stepScoreList)) {
            printThreeStrikePhrase()
            inputState = RESTART_INPUT
        }
    }
}

private fun printStartGamePhrase() {
    println(START_PHRASE)
}

private fun printOngoingInputPhrase() {
    print(ONGOING_INPUT_PHRASE)
}

private fun printRestartInputPhrase() {
    println(RESTART_INPUT_PHRASE)
}

private fun printThreeStrikePhrase() {
    println(THREE_STRIKE_PHRASE)
}

private fun printScore(stepScoreList: List<Int>) {
    if (stepScoreList[BALL] == 0) {
        println(stepScoreList[STRIKE].toString() + STRIKE_PHRASE)
        return
    }
    if (stepScoreList[STRIKE] == 0) {
        println(stepScoreList[BALL].toString() + BALL_PHRASE)
        return
    }
    println(stepScoreList[BALL].toString() + BALL_PHRASE + " " + stepScoreList[STRIKE].toString() + STRIKE_PHRASE)
}

private fun getRandomNumberString(stringLength: Int): String {
    var randomNumberString = ""
    while (randomNumberString.length < stringLength) {
        val stageNumber = pickNumberInRange(1, 9)
        if (stageNumber.toString() !in randomNumberString) {
            randomNumberString += stageNumber
        }
    }

    return randomNumberString
}

private fun isInputTypeNumber(userInput: String): Boolean = Pattern.matches("^[0-9]+$", userInput)

private fun checkInputLength(userInput: String, expectedLength: Int): Boolean = userInput.length == expectedLength

private fun checkDuplicatePartInInput(userInput: String): Boolean = userInput.length == userInput.toSet().size

private fun checkValidateRestartInput(userInput: String): Boolean = userInput == "1" || userInput == "2"

private fun checkAppropriateOngoingInput(userInput: String) {
    if (!checkInputLength(userInput, 3)) throw IllegalArgumentException("입력된 숫자의 길이가 적절치 않습니다.")
    if (!isInputTypeNumber(userInput)) throw IllegalArgumentException("입력이 숫자타입이 아닙니다")
    if (!checkDuplicatePartInInput(userInput)) throw IllegalArgumentException("중복된 숫자가 입력되었습니다.")
}

private fun checkAppropriateRestartInput(userInput: String) {
    if (!checkInputLength(userInput, 1)) throw IllegalArgumentException("입력된 숫자의 길이가 적절치 않습니다.")
    if (!isInputTypeNumber(userInput)) throw IllegalArgumentException("입력이 숫자타입이 아닙니다")
    if (!checkValidateRestartInput(userInput)) throw IllegalArgumentException("적절하지 못한 숫자가 입력되었습니다")
}

private fun getGameState(userInput: String): GameState {
    when (userInput) {
        ONGOING_STATE.stateNumber -> return ONGOING_STATE
        END_STATE.stateNumber -> return END_STATE
    }
    throw IllegalStateException("RESTART_INPUT 관련 예외처리에서 거르지 못한 예외가 있음")
}

private fun calcIsNothing(userInput: String, randomNumberString: String): Pair<MutableList<Int>, Boolean> {
    var nothingState = true
    val scoreCandidateList = mutableListOf<Int>()

    for (eachNumberIndex in userInput.indices) {
        if (userInput[eachNumberIndex] in randomNumberString) {
            nothingState = false
            scoreCandidateList.add(eachNumberIndex)
        }
    }
    if (nothingState) println(NOTHING_PHRASE)

    return Pair(scoreCandidateList, nothingState)
}

private fun calcStepScoreList(
    userInput: String,
    randomNumberString: String,
    scoreCandidateList: MutableList<Int>
): MutableList<Int> {
    val stepScoreList = mutableListOf(0, 0)
    for (scoreCandidateIndex in scoreCandidateList) {
        if (userInput[scoreCandidateIndex] == randomNumberString[scoreCandidateIndex]) stepScoreList[STRIKE] += 1
        else stepScoreList[BALL] += 1
    }

    return stepScoreList
}

private fun checkThreeStrike(stepScoreList: List<Int>): Boolean = stepScoreList[STRIKE] == 3
