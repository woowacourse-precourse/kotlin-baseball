package baseball.view

import camp.nextstep.edu.missionutils.Console

fun inputUserValue(): List<Int> {
    print("숫자를 입력해주세요 :")
    return checkInput(Console.readLine())
}

fun checkInput(input: String): List<Int> {
    val list = mutableListOf<Int>()
    if (!checkInputLength(input)) {
        throw IllegalArgumentException("3개만 입력할 수 있습니다.")
    }

    return list
}

fun checkInputLength(input: String): Boolean {
    if(input.length != 3) {
        return false
    }
    return true
}

fun checkInputElement(input: String): Boolean {
    val firstElement = input[0]
    val afterCheckList = input.filter { firstElement != it }
    if (afterCheckList.length < 2) {
        throw IllegalArgumentException("중복한 입력은 할 수 없습니다.")
    }
    return true
}

