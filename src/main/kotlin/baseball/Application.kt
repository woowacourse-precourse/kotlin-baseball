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

        var ballCount = getBallCount(userInputNumber, answerNumber)

    } while (true)
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