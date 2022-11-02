package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    gameStartText()
    startBaseball()
}

fun startBaseball() {
    while (true) {
        val numberList = mutableListOf<Int>()
        inputNumbers(numberList)

    }
}

fun inputNumbers(numberList: MutableList<Int>) {
    while (numberList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!numberList.contains(randomNumber)) {
            numberList.add(randomNumber)
        }
    }
}

fun gameStartText() = println("숫자 야구 게임을 시작합니다.")

