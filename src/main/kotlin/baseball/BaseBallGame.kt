package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun gameStart() {
    while (true) {
        val computer = makeRandomBallNumbers()
        printGameStartMessage()
        playGame(computer)
        printReGameMessage()
        val reGame = Console.readLine()
        if (reGame == "2") break
    }
}

private fun makeRandomBallNumbers(): MutableList<Int> {
    val computer = mutableListOf<Int>()

    while (computer.size < 3) {
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
        strike == 0 && ball == 0 -> "낫싱"
        strike == 3 -> "3스트라이크"
        ball == strike -> "${strike}스트라이크"
        strike != 0 -> "${ball - strike}볼 ${strike}스트라이크"
        else -> "${ball}볼"
    }
}

private fun checkThreeStrike(computer: MutableList<Int>, input: String): Boolean {
    if (countingStrike(computer, input) == 3) {
        printGameEndMessage()
        return true
    }
    return false
}
