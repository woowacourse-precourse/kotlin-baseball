package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun gameStart() {
    while (true) {
        val computer = makeRandomBallNumbers()
        println("숫자 야구 게임을 시작합니다.")
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

fun checkThreeStrike(computer: MutableList<Int>, input: String?): Boolean {
    TODO("Not yet implemented")
}


fun inputNumberException(input: String?) {
    TODO("Not yet implemented")
}
