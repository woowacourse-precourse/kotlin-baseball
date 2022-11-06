package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {

    println("숫자 야구 게임을 시작합니다.")
    BaseballGame(getComputerInput())
        .mainGame()
}


class BaseballGame(computer: String) {
    private val computerInput: String = getComputerInput()

    fun mainGame() {
        var start = true
        while (start) {
            val userInput = makeUserInput()
            val gameOver = (strike(userInput) == 3)

            checkCriteria(userInput)

            if (gameOver) {
                start = playAgain(userInput)
            }
        }
    }

    fun makeUserInput(): String {
        print("숫자를 입력해주세요 : ")
        val userInput = readLine()!!

        if (userInput.length > 3) {
            throw IllegalArgumentException("잘못된 값을 입력했습니다.")
        }
        return userInput
    }

    private fun playAgain(userInput: String): Boolean {
        println("${strike(userInput)}스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
        val inputNumber: String = readLine()!!
        if (inputNumber == "1") {
            return true
        }
        return false
    }


    private fun checkCriteria(userInput: String) {
        when (ball(userInput)) {
            0 -> {
                if (strike(userInput) == 0) return println("낫싱")
                if (strike(userInput) == 1) return println("${strike(userInput)}스트라이크")
                if (strike(userInput) == 2) return println("${strike(userInput)}스트라이크")
            }

            1 -> {
                if (strike(userInput) == 0) return println("${ball(userInput)}볼")
                if (strike(userInput) == 1) return println("${ball(userInput)}볼 ${strike(userInput)}스트라이크")

            }

            2 -> {
                if (strike(userInput) == 0) return println("${ball(userInput)}볼")
                if (strike(userInput) == 1) return println("${ball(userInput)}볼 ${strike(userInput)}스트라이크")

            }

            3 -> println("${ball(userInput)}볼")
        }
    }

    fun strike(user: String): Int {
        val userInput: String = user
        var strikeCount = 0
        for (index in userInput.indices) {
            if (computerInput[index] == user[index]) strikeCount++
        }
        return strikeCount

    }

    fun ball(user: String): Int {
        val userInput: String = user
        var ballCount = 0
        for (index in userInput.indices) {
            if (computerInput[index] != user[index] && computerInput.contains(user[index])) ballCount++
        }
        return ballCount
    }
}

fun getComputerInput(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}

