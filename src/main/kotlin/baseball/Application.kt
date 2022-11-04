package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

}

fun printStartGame() {
    println("숫자 야구 게임을 시작합니다.")
}

fun printEnterNumber() {
    print("숫자를 입력해주세요 : ")
}

fun countBall(userNumber: List<Int>, computerNumber: List<Int>): Int {
    var ball = 0
    userNumber.forEach { num ->
        if (computerNumber.contains(num)) ball++
    }
    return ball
}

fun countStrike(userNumber: List<Int>, computerNumber: List<Int>): Int {
    var strike = 0
    for (index in userNumber.indices) {
        if (userNumber[index] == computerNumber[index]) strike++
    }
    return strike
}

fun getFinalNumberOfBallBySubtractStrikeFromBall(ball: Int, strike: Int) = ball - strike

fun isThreeStrike(strike: Int): Boolean {
    return strike == 3
}

fun printThreeStrike() {
    println("3스트라이크")
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun printNothing(ball: Int, strike: Int) {
    if (ball == 0 && strike == 0) print("낫싱")
}

fun printBall(ball: Int) {
    if (ball != 0) print("${ball}볼 ")
}

fun printStrike(strike: Int) {
    if (strike != 0) print("${strike}스트라이크")
}

fun reStart(input: String){
   if (input=="1") run { main() }
}