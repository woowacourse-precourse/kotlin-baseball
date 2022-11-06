package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computerNumber = randomNumber()
    val userNumber = getUserInput()
    TODO("프로그램 구현")
}

fun randomNumber(): MutableList<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val number = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(number)) {
            computerNumber.add(number)
        }
    }
    return computerNumber
}

fun getUserInput(): MutableList<Int> {
    val userNumber = mutableListOf<Int>()
    print("숫자를 입력해주세요 : ")
    val input = Console.readLine()

    input.forEach {
        userNumber.add(it - '0')
    }
    return userNumber
}