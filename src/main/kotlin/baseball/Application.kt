package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

const val START_GAME = "숫자 야구 게임을 시작합니다."
const val END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val RESTART = "1"
const val END = "2"
const val STRIKE = "스트라이크"
const val BALL = "볼"
const val NOTHING = "낫싱"
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
        checkHint(input, answer)
        if (checkAnswer(input, answer)) {
            break
        }
    }
    println(END_GAME)
    restartGame()
}
fun restartGame(){
    println(RESTART_GAME)
    when (userInput()){
        RESTART -> startGame()
        END -> return
        else -> throw IllegalArgumentException()
    }
}

fun checkAnswer(input: String, answer: String): Boolean {
    return input == answer
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
    printHint(ballCount, strikeCount)
}

fun printHint(ballCount: Int, strikeCount: Int) {
    if (strikeCount == 0 && ballCount == 0) {
        println(NOTHING)
    }
    if (strikeCount > 0 && ballCount == 0) {
        println("$strikeCount$STRIKE")
    }
    if (strikeCount == 0 && ballCount > 0) {
        println("$ballCount$BALL")
    }
    if (strikeCount > 0 && ballCount > 0) {
        println("$ballCount$BALL $strikeCount$STRIKE")
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