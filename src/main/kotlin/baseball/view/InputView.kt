package baseball.view

import baseball.util.Validator.check3digitNum
import baseball.util.Validator.checkCommand
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputNumber(): String {
        val number: String
        try {
            number = Console.readLine()
            check3digitNum(number)
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(e.message)
        }
        return number
    }

    fun inputCommand(): String {
        val answer: String
        try {
            answer = Console.readLine()
            checkCommand(answer)
        } catch (e: java.lang.IllegalArgumentException) {
            throw java.lang.IllegalArgumentException(e.message)
        }
        return answer
    }
}