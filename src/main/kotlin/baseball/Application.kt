package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

const val RESTART = 1
const val FINISH = 2
var randomNum = 0

fun main() {
    printStartText()
    makeRandomNumber()

    while (true) {
        when (solution()) {
            RESTART -> continue
            FINISH -> break
            else -> throw IllegalArgumentException("1 또는 2를 입력하세요.")
        }
    }
}

private fun printStartText() {
    println("숫자 야구 게임을 시작합니다.")
}

fun makeRandomNumber() {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    randomNum = computer.joinToString("").toInt()
}

private fun solution(): Int {
    val inputNum = inputGuessNumber()
    if (isRightInput(inputNum)) {
        val (ball, strike) = getBallAndStrike(inputNum)
        printResult((Pair(ball, strike)))
        if (strike == 3) {
            return inputRestartOrFinishNum()
        }
        return RESTART
    } else throw IllegalArgumentException("1~9 사이의 서로 다른 세자리 수를 입력하세요")
}

private fun inputGuessNumber(): Int {
    print("숫자를 입력해주세요 : ")
    return Console.readLine().toInt()
}

private fun isRightInput(num: Int) = isThreeDigitNum(num) && !existZero(num) && isDifferentNum(num)

fun isThreeDigitNum(num: Int) = num in (100..999)

fun existZero(num: Int) = num.toString().contains('0')

fun isDifferentNum(num: Int): Boolean {
    val set = mutableSetOf<Char>()
    num.toString().map {
        set.add(it)
    }
    return set.size == 3
}

private fun getBallAndStrike(inputNum: Int): Pair<Int, Int> {
    val set = mutableSetOf<Int>()
    var strike = 0

    inputNum.toString().map { set.add(it.toString().toInt()) }
    randomNum.toString().map { set.add(it.toString().toInt()) }
    (0..2).forEach {
        if (inputNum.toString()[it] == randomNum.toString()[it])
            strike += 1
    }
    val ball = 6 - set.size - strike

    return Pair(ball, strike)
}

fun printResult(pair: Pair<Int, Int>) {
    val ball = pair.first
    val strike = pair.second
    when {
        strike > 0 && ball > 0 -> println("${ball}볼 ${strike}스트라이크")
        strike == 3 && ball == 0 -> println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        strike > 0 && ball == 0 -> println("${strike}스트라이크")
        strike == 0 && ball > 0 -> println("${ball}볼")
        strike == 0 && ball == 0 -> println("낫싱")
    }
}

fun inputRestartOrFinishNum(): Int {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val num = Console.readLine().toInt()
    if (num == RESTART) makeRandomNumber()
    return num
}