package baseball

import camp.nextstep.edu.missionutils.Console
import kotlin.IllegalArgumentException as IllegalArgumentException

fun processUserInput(): String? {
    return Console.readLine()
}

fun isNumeric(userInput: String): Any {
    return userInput.chars().allMatch { eachChar -> Character.isDigit(eachChar) }
}

fun checkException(userInput: String) {
    var isValid = true

    when {
        userInput.length != 3 -> isValid = false
        isNumeric(userInput) == false -> isValid = false
    }

    if (!isValid) {
        throw IllegalArgumentException("입력 오류입니다.")
    }
}


fun main() {
    TODO("프로그램 구현")
}
