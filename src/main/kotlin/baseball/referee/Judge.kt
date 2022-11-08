package baseball.referee

import baseball.user.inputUserNumber

/**스트라이크와 볼수를 판단하는 기능**/
fun judgeStrikeAndBallCount(computerRandomNumber: String) : Int {
    val userNumber= inputUserNumber()
    val strike= checkStrike(userNumber, computerRandomNumber)
    printResult(checkStrike(userNumber, computerRandomNumber), checkBall(userNumber, computerRandomNumber,strike ))
    return strike
}

fun checkStrike(userInputNumber: String,computerRandomNumber: String): Int {
    var strike = 0

    for (index in userInputNumber.indices)
        if (userInputNumber[index] == computerRandomNumber[index]) strike++

    return strike
}

fun checkBall(
        userInputNumber: String,
        computerRandomNumber: String,
        strike: Int): Int {

    var ball = 0

    for (userInputNumberWord in userInputNumber)
        if (computerRandomNumber.contains(userInputNumberWord)) ball++

    ball -= strike

    return ball
}

fun printResult(strike: Int, ball: Int) {

    return when {
        1 <= strike && 1 <= ball -> println("$ball" + "볼" + " " + "$strike" + "스트라이크")
        1 <= strike && ball == 0 -> println(("$strike" + "스트라이크"))
        strike == 0 && 1 <= ball -> println("$ball" + "볼")
        else -> println("낫싱")
    }
}
