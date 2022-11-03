package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    println("숫자 야구 게임을 시작합니다.")
    val computer = createRandomNumber()
    val userNumber = inputUserNumber()
}

fun createRandomNumber(): MutableList<Int> {
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains((randomNumber))) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun inputUserNumber() {
    print("숫자를 입력해주세요 : ")
    val user = readLine().toString()
}

fun isNumber(user:String): Boolean {
    return try {
        user.toInt()
        true
    } catch (e: NumberFormatException) {
        println("문자는 포함할 수 없습니다. 다시 입력해주세요.")
        inputUserNumber()
        false
    }
}

