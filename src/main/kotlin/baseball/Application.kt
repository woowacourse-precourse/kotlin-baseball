package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val RESTART = 1
const val EXIT = 2

fun main() {
    printStartMessage()
    baseballGame()
}

fun printStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun baseballGame() {
    val computer = generateRandomNumber()

    while (true) {

    }
}

fun generateRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
