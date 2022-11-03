package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    while (true){
        val robotAnswer = generateRandomNumber()

        print("숫자를 입력해주세요 : ")
        val playerInput = Console.readLine()

        if (checkInputNumberValid(playerInput).not()){
            throw java.lang.IllegalArgumentException("Invalid Input")
        }

        val ballScore = findBallScore(playerInput, robotAnswer)
        val strikeScore = findStrikeScore(playerInput, robotAnswer)
        println(makeFormattedResult(ballScore, strikeScore))

        if (strikeScore == 3){
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val endingInput = Console.readLine()

            if (checkEndingNumberValid(endingInput).not()){
                throw java.lang.IllegalArgumentException("Invalid Input")
            }

            if (endingInput == "2"){
                break
            }
        }
    }
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