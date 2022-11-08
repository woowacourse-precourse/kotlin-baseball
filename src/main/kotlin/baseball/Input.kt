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
        !answer.all { answer.count { char -> char == it } == 1 } -> throw IllegalArgumentException(INVALID_ANSWER.message)
    }
}

fun readAnswerAboutRestart(): Restart {
    val answer = Console.readLine()
    validateAnswerAboutRestart(answer)
    return when (answer) {
        "1" -> Restart.YES
        else -> Restart.NO
    }
}

private fun validateAnswerAboutRestart(answer: String) {
    if (!(answer == "1" || answer == "2"))
        throw IllegalArgumentException(INVALID_ANSWER_ABOUT_REPLAY.message)
}