package baseball.view

import baseball.util.Validator.check3digitNum
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
}