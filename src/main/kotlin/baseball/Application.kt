package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val START_GAME = "숫자 야구 게임을 시작합니다."
fun main() {
    startGame()
}

fun startGame() {
    println(START_GAME)
    val answer = pickRandomNumber()
    while (true) {
        val input = userInput()
    }
}

fun userInput(): String {
    return Console.readLine()
}

fun pickRandomNumber(): String {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber.joinToString("")
}