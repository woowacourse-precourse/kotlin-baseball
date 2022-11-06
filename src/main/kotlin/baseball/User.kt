package baseball

import camp.nextstep.edu.missionutils.Console

private const val NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : "
private const val WRONG_INPUT_MESSAGE = "잘못된 입력입니다."
private const val ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
private const val ASCII_ZERO = 48
const val RESTART_CODE = 1
const val EXIT_CODE = 2

class User {

    fun getGuessInput(): List<Int> {
        print(NUMBER_INPUT_MESSAGE)
        val input = Console.readLine()
        val guessNumbers = input.toList().map { it.code.plus(-ASCII_ZERO) }
        if (isGuessInputException(guessNumbers)) {
            throw IllegalArgumentException(WRONG_INPUT_MESSAGE)
        }
        return guessNumbers
    }

    fun isGuessInputException(guessInput: List<Int>): Boolean {
        if (guessInput.size != ANSWER_COUNT) {
            return true
        }
        guessInput.forEach {
            if (it !in MIN_NUMBER..MAX_NUMBER) {
                return true
            }
        }
        if (guessInput.toSet().size != ANSWER_COUNT) {
            return true
        }
        return false
    }

    fun getRestartOrNotInput(): Int {
        println(ASK_RESTART_MESSAGE)
        val input = Console.readLine()
        if (isRestartInputException(input)) {
            throw IllegalArgumentException(WRONG_INPUT_MESSAGE)
        }
        return input.toInt()
    }

    private fun isRestartInputException(restartInput: String): Boolean {
        val integerInput = restartInput.toIntOrNull()
        if (integerInput == RESTART_CODE || integerInput == EXIT_CODE) {
            return false
        }
        return true
    }

}