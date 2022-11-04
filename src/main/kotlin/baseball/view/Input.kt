package baseball.view

import camp.nextstep.edu.missionutils.Console

fun inputUserValue(): List<Int> {
    print("숫자를 입력해주세요 :")
    return checkInput(Console.readLine())
}

fun checkInput(input: String): List<Int> {
    val list = mutableListOf<Int>()
    return list
}

fun checkInputLength(input: String): Boolean {
    if(input.length != 3) {
        return false
    }
    return true
}