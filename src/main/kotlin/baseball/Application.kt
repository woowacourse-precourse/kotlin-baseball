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
        val userInputNumber = Console.readLine().trim()
        validationUserInputNumber(userInputNumber)
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
    val userInput = Console.readLine().trim()
    validationUserInputRestart(userInput)
    if (userInput == "1") {
        return true
    }
    return false
}

fun validationUserInputNumber(userInputNumber: String) {
    if (userInputNumber.isEmpty()) {
        throw IllegalArgumentException("입력값이 비었습니다.")
    }
    if (userInputNumber.contains(" ")){
        throw IllegalArgumentException("공백을 포함하지 않고 입력해주세요.")
    }
    if (!userInputNumber.matches(Regex("^\\d*\$"))) {
        throw IllegalArgumentException("숫자로 이루어진 값만 입력될 수 있습니다.")
    }
    if (userInputNumber.length != 3) {
        throw IllegalArgumentException("3자리의 숫자를 입력해주세요.")
    }
    if (userInputNumber[0] == userInputNumber[1]
        || userInputNumber[0] == userInputNumber[2]
        || userInputNumber[1] == userInputNumber[2]
    ) {
        throw IllegalArgumentException("서로 다른 수로 이루어져야합니다.")
    }
}

fun validationUserInputRestart(userInput: String) {
    if (userInput != "1" && userInput != "2") {
        throw IllegalArgumentException("1 또는 2의 값을 입력하세요.")
    }
}
