package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

    println("숫자 야구 게임을 시작합니다.")

    do {
        val computerNumber = createComputerNumber()
        do {
            print("숫자를 입력해주세요 : ")
            val input = Console.readLine()
            val inputNumber: List<Int> = stringInputToList(input)

            val isNothing = checkNothing(inputNumber, computerNumber)
            printResult(isNothing, inputNumber, computerNumber)

        } while (computerNumber != inputNumber)
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val answer = Console.readLine()
        val isQuit = askQuitOrNot(answer)
    } while (isQuit)

}

fun createComputerNumber(): MutableList<Int> {
    val computerNumber = mutableListOf<Int>()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber))
            computerNumber.add(randomNumber)
    }
    return computerNumber
}

fun stringInputToList(input: String): List<Int> {
    println(input)

    checkException(input)

    return input.map { it.digitToInt() }
}

fun checkNothing(inputNumber: List<Int>, computerNumber: MutableList<Int>): Boolean {
    for (num in inputNumber.indices)
        if (computerNumber.contains(inputNumber[num]))
            return false
    return true
}

fun checkStrike(inputNumber: List<Int>, computerNumber: MutableList<Int>): Int {
    var countStrike = 0

    for (num in inputNumber.indices)
        if (computerNumber[num] == inputNumber[num])
            countStrike++

    return countStrike
}

fun checkBall(inputNumber: List<Int>, computerNumber: MutableList<Int>): Int {
    var countBall = 0

    for (num in inputNumber.indices)
        if (computerNumber.contains(inputNumber[num]))
            countBall++

    return countBall
}

fun printBallAndStrike(inputNumber: List<Int>, computerNumber: MutableList<Int>) {
    val strike = checkStrike(inputNumber, computerNumber)
    val ball = checkBall(inputNumber, computerNumber) - strike

    if (ball != 0)
        print(ball.toString() + "볼 ")
    if (strike != 0)
        print(strike.toString() + "스트라이크")
    println()
}

fun printResult(isNothing: Boolean, userNumber: List<Int>, computerNumber: MutableList<Int>) {
    if (isNothing)
        println("낫싱")
    if (!isNothing)
        printBallAndStrike(userNumber, computerNumber)
}

fun askQuitOrNot(answer: String): Boolean {
    println(answer)

    if (!((answer == "1") || (answer == "2")))
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")

    if (answer == "1")
        return true
    return false
}

fun checkException(input: String) {
    if (input.length != 3)
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")

    if (!input.all { Character.isDigit(it) })
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")

    if (input.contains("0"))
        throw IllegalArgumentException("잘못된 값을 입력했습니다.")

    for (num in 0 until input.length - 1)
        if (input.substring(num + 1, input.length).contains(input[num]))
            throw IllegalArgumentException("잘못된 값을 입력했습니다.")
}