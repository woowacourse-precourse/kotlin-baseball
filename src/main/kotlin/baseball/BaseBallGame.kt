package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun gameStart() {
    while (true) {
        val computer = makeRandomBallNumbers()
        printGameStartMessage()
        playGame(computer)
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
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

        println("숫자를 입력해주세요 : ")
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
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return true
    }
    return false
}

fun inputNumberException(input: String) {
    when {
        input.toSet().size < 3 -> throw IllegalArgumentException("중복된 수입니다.")
        input.length > 3 -> throw IllegalArgumentException("3자리 수만 입력해주세요")
        "[1-9]{3}".toRegex().matches(input) -> throw IllegalArgumentException("0을 제외한 숫자만 입력해 주세요")
    }
}