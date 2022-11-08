package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    val game = Game().apply {
        onEnd = { onGameEnd() }
    }

    var isEnd = false
    while (!isEnd) {
        val computer = generateRandomThreeDigits()
        isEnd = game.playWith(computer)
    }
}

fun onGameEnd(): Boolean {
    println(
        "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    )
    val input = Console.readLine()
    validateEndInput(input)
    return input == "2"
}

fun validateEndInput(input: String) {
    if (!(input == "1" || input == "2")) {
        throw IllegalArgumentException("1 혹은 2를 입력해야합니다.")
    }
}

fun generateRandomThreeDigits(): List<Int> {
    val digits = mutableListOf<Int>()
    while (digits.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!digits.contains(randomNumber)) {
            digits.add(randomNumber)
        }
    }
    return digits
}
