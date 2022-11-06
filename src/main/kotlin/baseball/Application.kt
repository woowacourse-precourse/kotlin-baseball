package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    playNumberBaseball()
}

fun playNumberBaseball() {
    val answerNumber = createRandomAnswerNumber().toString()
    do {
        print("숫자를 입력해주세요 : ")
        val userInputNumber = Console.readLine()
        if (userInputNumber == answerNumber) {
            break
        }

        val ballCount = getBallCount(userInputNumber, answerNumber)
        printBallCount(ballCount)

    } while (true)
    println("3스트라이크")
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    if (isRestart()) {
        playNumberBaseball()
    }
}

fun createRandomAnswerNumber(): Int {
    val randomNumbers = mutableListOf<Int>()
    while (randomNumbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber)
        }
    }
    return randomNumbers[0] * 100 + randomNumbers[1] * 10 + randomNumbers[2]
}

fun getBallCount(userInputNumber: String, answerNumber: String): Pair<Int, Int> {
    var strike = 0
    var ball = 0
    for (index in answerNumber.indices) {
        if (answerNumber[index] == userInputNumber[index]) {
            strike++
            continue
        }
        if (answerNumber.contains(userInputNumber[index])) {
            ball++
        }
    }

    return Pair(ball, strike)
}

fun printBallCount(ballCount: Pair<Int, Int>) {
    val ball = ballCount.first
    val strike = ballCount.second
    if (ball == 0 && strike == 0) {
        println("낫싱")
        return
    }
    if (ball == 0) {
        println("${strike}스트라이크")
        return
    }
    if (strike == 0) {
        println("${ball}볼")
        return
    }
    println("${ball}볼 ${strike}스트라이크")
}

fun isRestart(): Boolean {
    val userInput = Console.readLine()

    if (userInput == "1") {
        return true
    }
    if (userInput == "2") {
        return false
    }
    return false
}