package baseball

import camp.nextstep.edu.missionutils.Console

fun main() {
    val user = getUserInput()
    println(user)
}

fun getUserInput(): String {
    val input = Console.readLine()
    return if (userInputValidation(input)) input else ""
}

fun userInputValidation(input: String): Boolean {
    if (checkIncludeZero(input) || checkInputLength(input) || checkDuplicateNum(input)) {
        throw IllegalArgumentException()
    }
    return true
}

fun checkIncludeZero(input: String): Boolean {
    return input.contains("0")
}

fun checkInputLength(input: String): Boolean {
    return (input.length != 3)
}

fun checkDuplicateNum(input: String): Boolean {
    return (input.toList().distinct().size != 3)
}