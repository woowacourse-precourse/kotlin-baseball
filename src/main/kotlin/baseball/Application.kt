package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

fun main() {
    while (true) {
        printStartNotice()
        val answer = createAnswer()

        simulateGame(answer)
    }
}

fun printStartNotice() {
    print("숫자 야구 게임을 시작합니다.")
}

fun createAnswer(): MutableList<Int> {
    val answer = mutableListOf<Int>()

    while (answer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!answer.contains(randomNumber)) {
            answer.add(randomNumber)
        }
    }
    return answer
}

fun simulateGame(answer: MutableList<Int>) {
    while (true) {
        val input = readLine()
        checkInput(input!!)
        val struck = getStrikeCount(answer, input)
    }
}

fun checkInput(input: String) {
    if (input.length != 3) {
        finishWithException()
    }

    val count = mutableSetOf<Int>()
    for (c in input) {
        if (!c.isDigit()) {
            finishWithException()
            count.add(c - '0')
        }
    }

    if (count.size != 3) {
        finishWithException()
    }
}

fun finishWithException() {
    try {
        throw IllegalArgumentException()
    } catch (e: Exception) {
        e.printStackTrace()
        exitProcess(0)
    }
}

fun getStrikeCount(answer: MutableList<Int>, input: String): Int {
    var count = 0

    for (i in 0..2) {
        if (answer[i] == input[i] - '0') {
            count++
        }
    }

    return count
}

fun getBallCount(answer: MutableList<Int>, input: String): Int {
    var count = 0

    for (i in 0..2) {
        for (j in 0..2) {
            count += isEqualNumber(answer[i], input[i] - '0')
        }
    }

    return count
}

fun isEqualNumber(num1: Int, num2: Int): Int {
    if (num1 == num2) {
        return 1
    } else {
        return 2
    }
}