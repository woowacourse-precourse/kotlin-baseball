package baseball

import camp.nextstep.edu.missionutils.Console

object Game {
    var input = ""
    var gameStop = false
    fun gameStart() {
        println("숫자 야구 게임을 시작합니다.")
        Computer.getCorrectRandomNumber()
        while (true) {
            if(gameStop){
                break
            }
            print("숫자를 입력해주세요 : ")
            input = Console.readLine()
            if (checkInputValueException(input)) {
                require(false)
            }
            Computer.compareInputWithCorrectNumber(input)
        }
    }

    private fun checkInputValueException(inputValue: String): Boolean {
        var checkExceptionFlag = false
        if (!checkInputLengthThree(inputValue) || !checkInputValueIsNumber(inputValue) || !checkInputDuplication(
                inputValue
            )
        ) {
            checkExceptionFlag = true
        }
        return checkExceptionFlag
    }

    private fun checkInputValueIsNumber(inputValue: String): Boolean {
        var checkFlag = false
        for (splitString in inputValue) {

            if (splitString.isDigit()) {
                checkFlag = true
            } else if (!splitString.isDigit()) {
                checkFlag = false
                break
            }
        }
        return checkFlag
    }

    private fun checkInputLengthThree(inputValue: String): Boolean {
        var checkFlag = false
        if (inputValue.length == 3) {
            checkFlag = true
        }
        return checkFlag
    }

    private fun checkInputDuplication(inputValue: String): Boolean {
        var checkFlag = false
        for (stringSplit in inputValue) {
            val splitCount = inputValue.count { it == stringSplit }
            if (splitCount <= 1) {
                checkFlag = true
            } else {
                checkFlag = false
                break
            }
        }
        return checkFlag
    }
}