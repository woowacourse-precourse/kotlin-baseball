package baseball

import baseball.Message.*
import camp.nextstep.edu.missionutils.Console

fun readAnswer(): String {
    val answer = Console.readLine()
    validateAnswer(answer)
    return answer
}

private fun validateAnswer(answer: String) {
    when {
        answer.length != 3 -> throw IllegalArgumentException(INVALID_ANSWER.message)
        !answer.all { it.isDigit() && it != '0' } -> throw IllegalArgumentException(INVALID_ANSWER.message)
        !answer.all { answer.count { c -> c == it } == 1 } -> throw IllegalArgumentException(INVALID_ANSWER.message)
    }
}