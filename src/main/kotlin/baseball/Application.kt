package baseball

fun main() {
    printGameStart()
    val computerNumbers = ComputerNumber().getRandomNumbers()
    if (!isNumberException(computerNumbers)) {
        throw IllegalArgumentException()
    }
    printInputNumber()
    val playerNumbers = PlayerNumber().inputPlayerNumber()
    if (!isNumberException(playerNumbers)) {
        throw IllegalArgumentException()
    }

    val baseBall = BaseBall(computerNumbers, playerNumbers)
    val strike = baseBall.getStrikeCount()
    val ball = baseBall.getBallCount()
    getResultMessage(ball, strike)
    printGameOver()
    PlayerNumber().exitGame()

}

fun printGameStart() {
    println("숫자 야구 게임을 시작합니다.")
}

fun printInputNumber() {
    print("숫자를 입력해주세요 : ")
}

fun printGameOver() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
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