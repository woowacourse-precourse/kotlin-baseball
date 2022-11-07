package baseball

import camp.nextstep.edu.missionutils.Console

class BaseballGame(var computerNumbers: ComputerNumbers) {
    fun start() {
        var processStatus = BaseballSetting.START_OR_RESTART.number
        BaseballStatement.printStart()

        while(processStatus == BaseballSetting.START_OR_RESTART.number){
            BaseballStatement.printInput()
            val userInput = Console.readLine()
            checkValidInput(userInput)

            var result = getResult(userInput)
        }
    }

    private fun getResult(userInput: String): Int{
        val strikeAndBall = computerNumbers.compareToUserInput(userInput)
        BaseballStatement.printResult(strike = strikeAndBall.first, ball = strikeAndBall.second)
        return strikeAndBall.first
    }

    private fun checkValidInput(userInput: String){
        if(userInput.length != BaseballSetting.DIGIT_NUMBER.number
                || !userInput.isNumberString()) throw IllegalArgumentException()
    }

    private fun String.isNumberString() = this.all { it.isDigit() }
}