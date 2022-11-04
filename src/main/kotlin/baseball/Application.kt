package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

const val START_GAME = "숫자 야구 게임을 시작합니다."
const val END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
const val RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
const val INPUT = "숫자를 입력해주세요 : "
const val RESTART = "1"
const val END = "2"
const val STRIKE = "스트라이크"
const val BALL = "볼"
const val NOTHING = "낫싱"
const val DIGIT_LENGTH = 3
const val START_RANDOM_NUMBER_RANGE = 1
const val END_RANDOM_NUMBER_RANGE = 9
fun main() {
    println(START_GAME)
    startGame()
}

fun startGame() {
    val answer = pickRandomNumber()
    do {
        val input = userInput()
        checkHint(input, answer)
    } while (!checkAnswer(input, answer))
    println(END_GAME)
    restartGame()
}

fun restartGame() {
    println(RESTART_GAME)
    when (userInput()) {
        RESTART -> startGame()
        END -> return
        else -> throw IllegalArgumentException()
    }
}

fun checkAnswer(input: String, answer: String): Boolean {
    return input == answer
}

fun checkHint(input: String, answer: String) {
    val strikeCount = input.filterIndexed { index, element ->
        answer.contains(element) && element == answer[index]
    }.length
    val ballCount = input.filterIndexed { index, element ->
        answer.contains(element) && element != answer[index]
    }.length
    printHint(ballCount, strikeCount)
}

fun printHint(ballCount: Int, strikeCount: Int) {
    when {
        strikeCount == 0 && ballCount == 0 -> println(NOTHING)
        strikeCount > 0 && ballCount == 0 -> println("$strikeCount$STRIKE")
        strikeCount == 0 && ballCount > 0 -> println("$ballCount$BALL")
        strikeCount > 0 && ballCount > 0 -> println("$ballCount$BALL $strikeCount$STRIKE")
    }
}

fun userInput(): String {
    print(INPUT)
    val input = Console.readLine()
    val numbers = input.toCharArray().toSet()
    when (numbers.size) {
        DIGIT_LENGTH -> return input
        else -> throw IllegalArgumentException()
    }
}

fun pickRandomNumber(): String {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < DIGIT_LENGTH) {
        val randomNumber = Randoms.pickNumberInRange(START_RANDOM_NUMBER_RANGE, END_RANDOM_NUMBER_RANGE)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber.joinToString("")
}