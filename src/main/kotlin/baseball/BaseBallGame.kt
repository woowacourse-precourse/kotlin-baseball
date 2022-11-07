package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

const val NOTHING = "낫싱"
const val THREE_STRIKE = "3스트라이크"
const val ZERO_COUNT = 0
const val FULL_COUNT = 3
const val RE_GAME = "2"

fun gameStart() {
    while (true) {
        val computer = makeRandomBallNumbers()
        printGameStartMessage()
        playGame(computer)
        printReGameMessage()
        val reGame = Console.readLine()
        if (reGame == RE_GAME) break
    }
}

private fun makeRandomBallNumbers(): MutableList<Int> {
    val computer = mutableListOf<Int>()

    while (computer.size < FULL_COUNT) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

private fun playGame(computer: MutableList<Int>) {
    while (true) {
        val input = Console.readLine()

        printInputMessage()
        inputNumberException(input)
        println(resultString(countingBall(computer, input), countingStrike(computer, input)))
        if (checkThreeStrike(computer, input)) break
    }
}

private fun countingBall(computer: MutableList<Int>, input: String): Int {
    var count = 0
    for (number in computer) {
        if (input.contains(number.toString())) count++
    }
    return count
}

private fun countingStrike(computer: MutableList<Int>, input: String): Int {
    var count = 0
    for (number in 0 until computer.size) {
        if (input.indexOf(computer[number].toString()) == number) count++
    }
    return count
}

private fun resultString(ball: Int, strike: Int): String {
    return when {
        strike == ZERO_COUNT && ball == ZERO_COUNT -> NOTHING
        strike == FULL_COUNT -> THREE_STRIKE
        ball == strike -> "${strike}스트라이크"
        strike != ZERO_COUNT -> "${ball - strike}볼 ${strike}스트라이크"
        else -> "${ball}볼"
    }
}

private fun checkThreeStrike(computer: MutableList<Int>, input: String): Boolean {
    if (countingStrike(computer, input) == FULL_COUNT) {
        printGameEndMessage()
        return true
    }
    return false
}
