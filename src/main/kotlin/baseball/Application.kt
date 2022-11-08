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

fun simulateGame() {
    while (true) {
        val input = readLine()
        checkInput(input!!)
    }
}

fun checkInput(input: String) {
    if(input.length != 3)  {
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