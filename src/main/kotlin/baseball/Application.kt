package baseball


fun main() {

    BaseballGame(computer = "123").startGame()

}

class BaseballGame(computer: String) {
    private val computerInput: String = computer


    fun startGame() {
        println("숫자 야구 게임을 시작합니다.")
        while (true) {
            print("숫자를 입력해주세요 : ")
            val userInput: String = readLine()!!

            // 예외처리
            checkException(userInput)
            // 조건 반환
            checkCriteria(userInput)

            // 3스트라이크인지 확인
            if (strike(userInput) == 3) {
                println("${strike(userInput)}스트라이크")
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
                val inputNumber: String = readLine()!!
                if (inputNumber == "1") continue
                if (inputNumber == "2") break
            }
        }
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


    fun checkException(userInput: String) {
        if (userInput.length > 3) {
            throw IllegalArgumentException("잘못된 값을 입력했습니다.")
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

