package baseball

import camp.nextstep.edu.missionutils.Console

class User {

    fun getGuessInput(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine()
        val guessNumbers = input.toList().map { it.code.plus(-48) }
        if (isGuessInputException(guessNumbers)) {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
        return guessNumbers
    }

    fun isGuessInputException(guessInput: List<Int>): Boolean {
        if (guessInput.size != 3) {
            return true
        }
        guessInput.forEach {
            if (it !in 1..9) {
                return true
            }
        }
        if (guessInput.toSet().size != 3) {
            return true
        }
        return false
    }

    fun getRestartOrNotInput(): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val input = Console.readLine()
        if (isRestartInputException(input)) {
            throw IllegalArgumentException("잘못된 입력입니다.")
        }
        return input.toInt()
    }

    fun isRestartInputException(restartInput: String): Boolean {
        val integerInput = restartInput.toIntOrNull()
        if (integerInput == 1 || integerInput == 2) {
            return false
        }
        return true
    }

}