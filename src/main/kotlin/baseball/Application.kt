package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computerNumber = getRandomNumber()
    printGameStart()
    inputUserNumber()
}

fun getRandomNumber(): MutableList<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}

fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun inputUserNumber() {
    print("숫자를 입력해주세요 : ")
    val userNumber: Int = readLine()!!.toInt()
}