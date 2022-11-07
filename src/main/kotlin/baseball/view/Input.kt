package baseball.view

import camp.nextstep.edu.missionutils.Console

fun inputUserValue(): List<Int> {
    print("숫자를 입력해주세요 :")
    val input = Console.readLine()
    return checkInput(input)
}

fun restart(complete: Boolean): Int {
    if(complete) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return Console.readLine().toInt()
    }
    return 0
}

fun checkInput(input: String): List<Int> {
    if (!checkInputLength(input)) {
        throw IllegalArgumentException("3개만 입력할 수 있습니다.")
    }
    if(!checkInputElement(input)) {
        throw IllegalArgumentException("중복한 입력은 할 수 없습니다.")
    }
    return inputToList(input)
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
        return false
    }
    return true
}

fun inputToList(input: String): List<Int> {
    var list = emptyList<Int>()
    runCatching {
        input.toInt()
    }.onFailure {
        throw IllegalArgumentException("1 ~ 9 사이의 수만 입력이 가능합니다.")
    }.onSuccess {
        list = intToList(it)
    }
    return list
}

fun intToList(input: Int): List<Int> {
    val list = mutableListOf<Int>()
    var num = input
    list.add(num/100)
    num %= 100
    list.add(num/10)
    num %= 10
    list.add(num / 1)
    return list
}