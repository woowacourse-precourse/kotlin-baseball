package baseball

import camp.nextstep.edu.missionutils.Randoms

var randomGeneratedNumber: String = ""
fun main() {
    generateRandomNumber()
    println("답 : $randomGeneratedNumber")
    printGuidelinePhraseAndWaitForInput()
}

fun generateRandomNumber() {
    val randomNumbersSet = mutableSetOf<Int>()

    while (randomNumbersSet.size != 3) {
        randomNumbersSet.add(
            Randoms.pickNumberInRange(1, 9)
        )
    }
    randomGeneratedNumber = randomNumbersSet.joinToString("")
}

fun printGuidelinePhraseAndWaitForInput() {
    print("숫자를 입력해주세요 : ")
    val userInput = readln()
}

fun String.gameResult(): GameResultType {
    // 유저
    return if (this == randomGeneratedNumber) GameResultType.CorrectResult
    else if (
        !this.contains(randomGeneratedNumber[0]) &&
        !this.contains(randomGeneratedNumber[1]) &&
        !this.contains(randomGeneratedNumber[2])
    ) GameResultType.NothingResult
    else GameResultType.NormalResult(
        countBallAndStrike(this, randomGeneratedNumber).first,
        countBallAndStrike(this, randomGeneratedNumber).second
    )
}

fun countBallAndStrike(userInput: String, answer: String): Pair<Int, Int> {
    var ballCount = 0
    var strikeCount = 0

    userInput.forEachIndexed { index, userNum ->
        if (userNum != answer[index] &&
            answer.contains(userNum)
        ) ballCount++
    }

    for (idx in 0 until 3) {
        if (userInput[idx] == answer[idx]) strikeCount++
    }

    return Pair(ballCount, strikeCount)
}

sealed class GameResultType {
    data class NormalResult(
        val ball: Int,
        val strike: Int
    ) : GameResultType()

    object NothingResult : GameResultType()

    object CorrectResult : GameResultType()
}