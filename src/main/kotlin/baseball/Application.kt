package baseball

import baseball.view.OutputView

fun main() {
    OutputView().printGameStart()

    do {
        val computerNumbers = ComputerNumber().getRandomNumbers()
        if (!isNumberException(computerNumbers)) {
            throw IllegalArgumentException()
        }
        do {
            OutputView().printInputNumber()
            val playerNumbers = PlayerNumber().inputPlayerNumber()
            if (!isNumberException(playerNumbers)) {
                throw IllegalArgumentException()
            }
            val baseBall = BaseBall(computerNumbers, playerNumbers)
            val strike = baseBall.getStrikeCount()
            val ball = baseBall.getBallCount()
            OutputView().printResult(ball, strike)
        } while (!isThreeStrike(strike))
        OutputView().printGameOver()
    } while (!PlayerNumber().exitGame())

}

fun isThreeStrike(strike: Int): Boolean {
    return strike == 3
}

fun isNumberException(number: List<Int>): Boolean {
    return number.size == 3 && isOneToNine(number) && isNotDuplicate(number)
}

fun isOneToNine(number: List<Int>): Boolean {
    return number.all { num -> num >= 1 && num <= 9 }
}

fun isNotDuplicate(number: List<Int>): Boolean {
    return number.size == number.distinct().size
}