package baseball

fun main() {
    val computerNumbers = ComputerNumber().getRandomNumbers()
    if (!isNumberException(computerNumbers)) {
        throw IllegalArgumentException()
    }

    val playerNumbers = PlayerNumber().inputPlayerNumber()
    if (!isNumberException(playerNumbers)) {
        throw IllegalArgumentException()
    }

    val baseBall = BaseBall(computerNumbers, playerNumbers)
    val strike = baseBall.getStrikeCount()
    val ball = baseBall.getBallCount()
    getResultMessage(ball, strike)

    PlayerNumber().exitGame()

}

fun getResultMessage(ball: Int, strike: Int) {
    if (strike == 0 && ball == 0) {
        println("낫싱")
    }
    if (strike > 0 && ball > 0) {
        println("${ball}볼 ${strike}스트라이크")
    }
    if (strike > 0 && ball == 0) {
        println("${strike}스트라이크")
    }
    if (ball > 0 && strike == 0) {
        println("${ball}볼")
    }
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