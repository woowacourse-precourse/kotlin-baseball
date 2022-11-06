package baseball

import camp.nextstep.edu.missionutils.Console

object Game {
    private var input = ""
    var gameStop = false
    fun gameStart() {
        println("숫자 야구 게임을 시작합니다.")
        Computer.getCorrectRandomNumber()
        while (true) {
            if (gameStop) {
                break
            }
            processInput()
        }
    }

    private fun processInput() {
        print("숫자를 입력해주세요 : ")
        input = Console.readLine()
        if (checkInputValueException(input)) {
            require(false)
        }
        Computer.compareInputWithCorrectNumber(input)
        Computer.printCurrentScore()
        Computer.resetScore()
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
        if (inputValue.length == Computer.INPUT_MAX_SIZE) {
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

    fun gameOver() {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        checkGameRestartOrStop()
    }

    private fun checkGameRestartOrStop() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var input = Console.readLine()
        if (input == Computer.INPUT_GAME_RESTART) {
            Computer.getCorrectRandomNumber()
        } else if (input == Computer.INPUT_GAME_STOP) {
            println("게임종료")
            gameStop = true
        } else if (input != "1" && input != "2") {
            require(false)
        }
    }
}