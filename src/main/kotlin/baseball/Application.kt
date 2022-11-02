package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    gameStartText()
    startBaseball()
}

fun startBaseball() {
    while (true) {
        val computerNumbers = mutableListOf<Int>()
        inputComputerNumbers(computerNumbers)
    }
}



fun inputComputerNumbers(numbers: MutableList<Int>) {
    while (numbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }
}

fun gameStartText() = println("숫자 야구 게임을 시작합니다.")

