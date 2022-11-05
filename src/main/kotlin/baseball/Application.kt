package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

const val RESTART = 1
const val FINISH = 2
var randomNum = 0

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    makeRandomNumber()

    while (true) {
        when (solution()) {
            RESTART -> continue
            FINISH -> break
            else -> throw IllegalArgumentException("1 또는 2를 입력하세요.")
        }
    }
}

private fun makeRandomNumber() {
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

private fun isThreeDigitNum(num: Int) = num in (100..999)

private fun existZero(num: Int) = num.toString().contains('0')

private fun isDifferentNum(num: Int): Boolean {
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

private fun printResult(pair: Pair<Int, Int>) {
    when (pair) {
        Pair(1, 0) -> println("1볼")
        Pair(1, 1) -> println("1볼 1스트라이크")
        Pair(1, 2) -> println("1볼 2스트라이크")
        Pair(2, 0) -> println("2볼")
        Pair(2, 1) -> println("2볼 1스트라이크")
        Pair(3, 0) -> println("3볼")
        Pair(0, 0) -> println("낫싱")
        Pair(0, 1) -> println("1스트라이크")
        Pair(0, 2) -> println("2스트라이크")
        Pair(0, 3) -> println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}

private fun inputRestartOrFinishNum(): Int {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val num = Console.readLine().toInt()
    if (num == RESTART) makeRandomNumber()
    return num
}