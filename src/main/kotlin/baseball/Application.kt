package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val START_GAME = "숫자 야구 게임을 시작합니다."
const val DIGIT_END = 2
const val DIGIT_START = 0
fun main() {
    println(START_GAME)
    startGame()
}

fun startGame() {
    val answer = pickRandomNumber()
    println(answer)
    while (true) {
        val input = userInput()
        println(checkHint(input, answer))
    }
}

fun checkHint(input: String, answer: String) {
    var ballCount = 0
    var strikeCount = 0

    for (index in DIGIT_START..DIGIT_END) {
        if (answer.contains(input[index]) && input[index] == answer[index]) {
            strikeCount++
        }
        if (answer.contains(input[index]) && input[index] != answer[index]) {
            ballCount++
        }
    }
    println("$ballCount $strikeCount")

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