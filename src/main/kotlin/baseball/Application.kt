package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

fun main() {
    while (true) {
        printStartNotice()
        val answer = createAnswer()

        val isContinue = simulateGame(answer)

        if (!isContinue) {
            break
        }
    }
}

fun printStartNotice() {
    print("숫자 야구 게임을 시작합니다.\n")
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

fun simulateGame(answer: MutableList<Int>): Boolean {
    while (true) {
        print("숫자를 입력해주세요 : ")

        val input = readLine()
        checkInput(input!!)

        val struck = getStrikeCount(answer, input)
        val balls = getBallCount(answer, input)

        if (balls != 0) {
            print("${balls}볼 ")
        }
        if (struck != 0) {
            print("${struck}스트라이크")
        }

        print("\n")

        if (struck == 3) {
            print(
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                        "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
            )

            break
        }
    }

    val isContinue = readLine()

    checkFinishInput(isContinue!!)
    return readLine() == "1"
}

fun checkFinishInput(isContinue: String) {
    if(!(isContinue == "1" || isContinue == "2")) {
        finishWithException()
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
        }
        count.add(c - '0')
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
            count += isBall(answer, input, i, j)
        }
    }

    return count
}

fun isBall(answer: MutableList<Int>, input: String, num1: Int, num2: Int): Int {
    if(num1 == num2) {
        return 0
    }

    return if(answer[num1] == input[num2] - '0') {
        1
    } else {
        0
    }
}