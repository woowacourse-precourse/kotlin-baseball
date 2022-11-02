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
        val userNumbers = inputUserNumbers()
    }
}

fun inputUserNumbers(): String {
    val input = readLine()!!
    //예외 사항 : 정수 인지* , 길이가 3인지 , 중복된 숫자는 없는지
    val userNumbers = input.map {
        it.digitToInt()
    }

    if (userNumbers.size != userNumbers.toSet().size || userNumbers.size != 3) {
        throw IllegalArgumentException()
    }

    return input
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

