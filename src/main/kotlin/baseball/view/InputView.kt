package baseball.view

import baseball.utils.checkNumberRange
import baseball.utils.checkNumbersLength
import baseball.utils.inputTypeException
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readNumbers(): List<Int> {
        val input = Console.readLine()
        with(input) {
            inputTypeException()
            checkNumbersLength(NUMBERS_LENGTH)
            checkNumberRange(LOWER_NUMBER,UPPER_NUMBER)
            return map { it.toString().toInt() }.toList()
        }
    }

    fun readRetry(): Int {
        val input = Console.readLine()
        with(input) {
            inputTypeException()
            checkNumbersLength(RETRY_END_LENGTH)
            checkNumberRange(RETRY, END)
        }
        return input.toInt()
    }

    companion object {
        const val NUMBERS_LENGTH = 3
        const val RETRY_END_LENGTH = 1
        const val UPPER_NUMBER = 9
        const val LOWER_NUMBER = 1
        const val RETRY = 1
        const val END = 2
    }
}