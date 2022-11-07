package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {

    println("숫자 야구 게임을 시작합니다.")
    Baseball(createComputerInput())
        .playGame()
}


class Baseball(computer: String) {
    private var computerInput = computer

    fun playGame() {
        var isPlaying = true
        while (isPlaying) {
            val userInput = createUserInput()
            val isEndedGame = (strike(userInput) == 3)

            checkCriteria(userInput)

            if (isEndedGame) {
                endGame(userInput)
                isPlaying = playAgain()
            }
        }
    }

    private fun endGame(userInput: String) {
        println("${strike(userInput)}스트라이크")
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    private fun createUserInput(): String {
        print("숫자를 입력해주세요 : ")
        val userInput: String = readLine()!!
        if (userInput.length > 3) {
            throw IllegalArgumentException("잘못된 값을 입력했습니다.")
        }
        return userInput
    }

    private fun playAgain(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
        val userInputNumber: String = readLine()!!
        if (userInputNumber == "1") {
            computerInput = createComputerInput()
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
            val isMetStrikeCriteria = (computerInput[index] == userInput[index])
            if (isMetStrikeCriteria) strikeCount++
        }
        return strikeCount

    }

    fun ball(userInput: String): Int {
        var ballCount = 0
        for (index in userInput.indices) {
            val isMetBallCriteria =
                (computerInput[index] != userInput[index] && computerInput.contains(userInput[index]))
            if (isMetBallCriteria) ballCount++
        }
        return ballCount
    }


}

private fun createComputerInput(): String {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
}
