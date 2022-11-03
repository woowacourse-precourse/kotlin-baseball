package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

}

fun makeFormattedResult(ball: Int, strike: Int): String = "${ball}볼 ${strike}스트라이크"

fun findStrikeScore(input: String, answer: String): Int = (input.indices).filter { input[it] == answer[it] }.size


fun findBallScore(input: String, answer: String): Int =
    (input.indices).filter { input[it] != answer[it] && input[it] in answer }.size

fun matchAnswer(input: String, answer: String): String {
    val ballValue = findBallScore(input, answer)
    val strikeValue = findStrikeScore(input, answer)

    return makeFormattedResult(ballValue, strikeValue)
}

fun generateRandomNumber(): String {
    val randomNumberSet = mutableSetOf<Int>()
    while (randomNumberSet.size != 3) {
        randomNumberSet.add(Randoms.pickNumberInRange(1, 9))
    }
    return randomNumberSet.joinToString("")
}

fun checkInputNumberValid(input: String): Boolean {
    val inputNumberSet = input.toSet()
    return Regex("[1-9]{3}").matches(input) && inputNumberSet.size == 3
}

fun checkEndingNumberValid(input: String): Boolean = input == "1" || input == "2"