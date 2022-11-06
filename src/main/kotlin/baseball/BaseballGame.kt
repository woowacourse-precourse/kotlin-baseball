package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballGame(var computerNumbers: ComputerNumbers) {

    fun start() {
        printStartString()
        printInputString()

        val userInput = Console.readLine()
        checkValidInput(userInput)


    }

    private fun checkValidInput(userInput: String){
        if(userInput.length != BaseballSetting.DIGIT_NUMBER.number
                || !isNumberString(userInput)) throw IllegalArgumentException()
    }

    private fun isNumberString(string: String) = string.all { it.isDigit() }

    private fun printStartString() = BaseballString.START.print()

    private fun printInputString() = BaseballString.INPUT.print()

}