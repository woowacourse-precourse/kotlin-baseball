package baseball

import baseball.Message.*
import camp.nextstep.edu.missionutils.Randoms

fun gameStart() {
    val computerNumber = createComputerNumber()
    do {
        print(REQUEST_INPUT_NUMBER.message)
        val answer = enteredAnswer()
        println(createHint(computerNumber, answer))
    } while (computerNumber != answer)
    println(FINISH.message)
}

fun createComputerNumber(): String {
    val computerNumber = mutableListOf<Int>()

    while (computerNumber.size < 3) {
        var pickedNumber = Randoms.pickNumberInRange(1, 9)
        while (computerNumber.contains(pickedNumber))
            pickedNumber = Randoms.pickNumberInRange(1, 9)
        computerNumber.add(pickedNumber)
    }

    return computerNumber.joinToString("")
}

fun createHint(computerNumber: String, answer: String): String {
    val ball = ballCount(computerNumber, answer)
    val strike = strikeCount(computerNumber, answer)

    return when {
        ball == 0 && strike == 0 -> "낫싱"
        ball != 0 && strike == 0 -> "${ball}볼"
        ball == 0 && strike != 0 -> "${strike}스트라이크"
        else -> "${ball}볼 ${strike}스트라이크"
    }
}

fun ballCount(computerNumber: String, answer: String): Int =
    computerNumber.count { answer.contains(it) && answer.indexOf(it) != computerNumber.indexOf(it) }

fun strikeCount(computerNumber: String, answer: String): Int =
    computerNumber.count { answer.contains(it) && answer.indexOf(it) == computerNumber.indexOf(it) }