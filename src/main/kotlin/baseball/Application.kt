package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        val robotAnswer = generateRandomNumber()
        var isDone = false

        while (isDone.not()) {

            print("숫자를 입력해주세요 : ")
            val playerInput = Console.readLine()

            checkInputNumberValid(playerInput)

            val ballScore = findBallScore(playerInput, robotAnswer)
            val strikeScore = findStrikeScore(playerInput, robotAnswer)
            isDone = computeScoreAndGetGameState(ballScore, strikeScore)
        }

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val endingInput = Console.readLine()

        checkEndingNumberValid(endingInput)

        if (endingInput == "2") {
            break
        }
    }
}

fun computeScoreAndGetGameState(ballScore: Int, strikeScore: Int): Boolean {
    println(makeFormattedResult(ballScore, strikeScore))
    return if (strikeScore == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        true
    } else {
        false
    }
}

fun makeFormattedResult(ball: Int, strike: Int): String {
    val resultStringList = mutableListOf<String>()
    if (ball != 0) {
        resultStringList.add("${ball}볼")
    }
    if (strike != 0) {
        resultStringList.add("${strike}스트라이크")
    }

    return if (resultStringList.size == 0) {
        "낫싱"
    } else {
        return resultStringList.joinToString(" ")
    }
}

fun findStrikeScore(input: String, answer: String): Int = (input.indices).filter { input[it] == answer[it] }.size

fun findBallScore(input: String, answer: String): Int =
    (input.indices).filter { input[it] != answer[it] && input[it] in answer }.size

fun generateRandomNumber(): String {
    val randomNumberList = mutableListOf<Int>()
    while (randomNumberList.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (randomNumberList.contains(randomNumber).not()) {
            randomNumberList.add(randomNumber)
        }
    }
    return randomNumberList.joinToString("")
}

fun checkInputNumberValid(input: String) {
    val inputNumberSet = input.toSet()
    if ((Regex("[1-9]{3}").matches(input) && inputNumberSet.size == 3).not()) {
        throw java.lang.IllegalArgumentException("Invalid Input")
    }
}

fun checkEndingNumberValid(input: String) {
    if ((input == "1" || input == "2").not()) {
        throw java.lang.IllegalArgumentException("Invalid Input")
    }
}