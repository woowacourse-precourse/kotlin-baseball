package baseball

fun main() {
    printStartMessage()
    var computer = createComputerAnswer()

    var ball = 0
    var strike = 0

    while (strike != 3) {
        val user = inputUserNumber()
        ball = checkBall(computer, user)
        strike = checkStrike(computer, user)
        printHintMessage(ball, strike)

        if (strike == 3) {
            strike = gameRestart()
            computer = createComputerAnswer()
        }
    }
}
