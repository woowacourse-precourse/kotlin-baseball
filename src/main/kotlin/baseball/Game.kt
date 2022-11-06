package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms


fun printStartMessage() {
    println("숫자 야구 게임을 시작합니다")
}

fun createComputerAnswer(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.count() < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun checkBall(computer: MutableList<Int>, user: MutableList<Int>): Int {
    var ballCount = 0
    for (i in 0..2) {
        if (user[i] == computer[(i + 1) % 3]) {
            ballCount += 1
        }
        if (user[i] == computer[(i + 2) % 3]) {
            ballCount += 1
        }
    }
    return ballCount
}

fun checkStrike(computer: MutableList<Int>, user: MutableList<Int>): Int {
    var strikeCount = 0
    for (i in 0..2) {
        if (user[i] == computer[i]) {
            strikeCount += 1
        }
    }
    return strikeCount
}

fun gameRestart(): Int {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var input = Console.readLine().toInt() + 1
    if (2 > input || input > 3) {
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")
    }
    if (input == 3) {
        println("게임 종료")
    }
    return input
}
