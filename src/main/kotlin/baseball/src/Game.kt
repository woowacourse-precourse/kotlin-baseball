package baseball.src

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Game {
    private var computer = createComputerAnswer()
    private var user = mutableListOf<Int>()
    private var ball = 0
    private var strike = 0

    fun startGame() {
        while (strike != 3) {
            this.user = inputUserNumber()
            this.ball = checkBall(computer, user)
            this.strike = checkStrike(computer, user)
            printHintMessage(ball, strike)
        }
    }
    fun gameRestart() {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var input = Console.readLine().toInt()
        if (input != 1 && input != 2) {
            throw IllegalArgumentException("잘못된 값을 입력했습니다.")
        }
        if (input == 1) {
            return startGame()
        }
        println("게임 종료")
        return
    }

}


fun printStartMessage() {
    println("숫자 야구 게임을 시작합니다")
}

fun createComputerAnswer(): MutableList<Int> {
    var computer = mutableListOf<Int>()
    while (computer.count() < 3) {
        var randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
fun checkBall(computer: MutableList<Int>, user: MutableList<Int>): Int {
    var ballCount = 0
    for (i in 0..2) {
        if (user[i] == computer[(i + 1) % 3]) {
            ballCount += 1
        }
        if (user[i] == computer[(i + 2) % 3]) {
            ballCount += 1
        }
    }
    return ballCount
}

fun checkStrike(computer: MutableList<Int>, user: MutableList<Int>): Int {
    var strikeCount = 0
    for (i in 0..2) {
        if (user[i] == computer[i]) {
            strikeCount += 1
        }
    }
    return strikeCount
}

