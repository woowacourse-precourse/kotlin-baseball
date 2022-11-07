package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computerNumber = getRandomNumber()
    printGameStart()
    val userNumber = inputUserNumber()
    if(!checkInput(userNumber)) throw IllegalArgumentException()
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

fun inputUserNumber(): String {
    print("숫자를 입력해주세요 : ")
    return readLine().toString()
}

fun checkInput(number: String): Boolean {
    if(number.length != 3) return false
    number.forEach {
        if(it !in '1'..'9') return false
    }
    if(number.toSet().size != 3) return false
    return true
}