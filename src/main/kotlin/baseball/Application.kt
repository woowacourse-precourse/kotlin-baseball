package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.text.StringBuilder

enum class Score {
    NOTHING,
    STRIKE,
    BALL
}

fun formatScore(scores: List<Int>): String {
    val formattedScore = StringBuilder()
    if (scores[Score.BALL.ordinal] != 0)
        formattedScore.append("${scores[Score.BALL.ordinal]}볼")
    if (scores[Score.STRIKE.ordinal] != 0)
        formattedScore.append("${scores[Score.BALL.ordinal]}스트라이크")
    if (scores[Score.NOTHING.ordinal] != 0)
        return "낫싱"
    return formattedScore.toString()
}

fun determineScore(randomNumber: String, userNumber: String): List<Int> {
    val scores = mutableListOf(0, 0, 0)
    for (i in 0..2) {
        val score = compareNumber(randomNumber, userNumber, i)
        scores[score.ordinal] += 1
    }
    return scores
}

fun compareNumber(randomNumber: String, userNumber: String, index: Int): Score {
    if (randomNumber[index] == userNumber[index])
        return Score.STRIKE
    else if (randomNumber.contains(userNumber[index]))
        return Score.BALL
    return Score.NOTHING
}

fun generateRandomNumber(): String {
    val randomNum = Randoms.pickUniqueNumbersInRange(1, 9, 3)
    return randomNum.toString()
}

fun getUserInput(): String {
    val input = Console.readLine()
    if (input == "1" || input == "2")
        return input
    if (input.length != 3)
        throw IllegalArgumentException()
    if (!input.all { char -> char.isDigit() })
        throw IllegalArgumentException()
    return input
}

fun main() {
    TODO("프로그램 구현")
}
