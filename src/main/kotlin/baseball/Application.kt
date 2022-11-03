package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    printGameStart()

    val computerNumber = generateComputerNumber()
    val userNumber = getUserNumber()
}

fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun generateComputerNumber(): List<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    return computerNumber
}

fun getUserNumber(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val userInput = readLine()

    val userNumber = mutableListOf<Int>()
    userInput?.forEach { c ->
        userNumber.add(Character.getNumericValue(c))
    }

    return userNumber
}