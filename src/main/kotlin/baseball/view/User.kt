package baseball.view

import baseball.util.INPUT_NUMBER_MESSAGE
import baseball.view.validator.InputValidator

class User {

    fun createNumber(): String {
        print(INPUT_NUMBER_MESSAGE)
        val userInput = readLine()!!
        InputValidator.validateUserInput(userInput)
        return userInput
    }
}