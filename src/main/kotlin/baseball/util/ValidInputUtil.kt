package baseball.util

import camp.nextstep.edu.missionutils.Console

fun isNumber(s: String?): Boolean {
    return if (s.isNullOrEmpty()) false else s.all { Character.isDigit(it) }
}

fun isDuplicate(s: String): Boolean {
    return s.toList().distinct().size == 3
}

fun userInput(): String {
    val userNumber = Console.readLine()
    if (userNumber.length != 3 || userNumber.contains("0") || !isNumber(userNumber) || !isDuplicate(userNumber)) {
        throw IllegalAccessException()
    }
    return userNumber
}