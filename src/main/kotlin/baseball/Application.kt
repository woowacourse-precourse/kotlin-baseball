package baseball

import baseball.game.Baseball
import baseball.model.AnswerBoard
import baseball.model.Computer
import baseball.view.User
import camp.nextstep.edu.missionutils.Randoms


fun main() {

    val answerBoard = AnswerBoard()
    val user = User()
    val computer = Computer()
    val baseball = Baseball(answerBoard, user, computer)
    baseball.play()
}

class Baseball(computer: String) {
    private var computerInput = computer

    fun playGame() {
        var isPlaying = true
        while (isPlaying) {
            val userInput = createUserInput()
            val isEndedGame = (strike(userInput) == THREE_STRIKE)

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


    private fun playAgain(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요")
        val userInputNumber: String = readLine()!!
        if (userInputNumber == "1") {
            computerInput = createComputerInput()
            return true
        }
        return false
    }


    // 완료
    private fun checkCriteria(userInput: String) {
        when (ball(userInput)) {
            NONE_BALL -> {
                if (strike(userInput) == NONE_STRIKE) println("낫싱")
                if (strike(userInput) == ONE_STRIKE) println("${strike(userInput)}스트라이크")
                if (strike(userInput) == TWO_STRIKE) println("${strike(userInput)}스트라이크")
            }

            ONE_BALL -> {
                if (strike(userInput) == NONE_STRIKE) println("${ball(userInput)}볼")
                if (strike(userInput) == ONE_STRIKE) println("${ball(userInput)}볼 ${strike(userInput)}스트라이크")

            }

            TWO_BALL -> {
                if (strike(userInput) == NONE_STRIKE) println("${ball(userInput)}볼")
                if (strike(userInput) == ONE_STRIKE) println("${ball(userInput)}볼 ${strike(userInput)}스트라이크")

            }

            THREE_BALL -> println("${ball(userInput)}볼")
        }
    }
    // 완료
    fun strike(userInput: String): Int {
        var strikeCount = 0
        for (index in userInput.indices) {
            val isMetStrikeCriteria = (computerInput[index] == userInput[index])
            if (isMetStrikeCriteria) strikeCount++
        }
        return strikeCount

    }
    // 완료
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
// 완료
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

// 완료
fun createUserInput(): String {
    print("숫자를 입력해주세요 : ")
    val userInput: String = readLine()!!
    if (userInput.length > 3) {
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")
    }
    return userInput
}

const val NONE_BALL = 0
const val ONE_BALL = 1
const val TWO_BALL = 2
const val THREE_BALL = 3

const val NONE_STRIKE = 0
const val ONE_STRIKE = 1
const val TWO_STRIKE = 2
const val THREE_STRIKE = 3
