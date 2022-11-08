package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun pickNumbers(): List<Char> {
    var numbers = ""
    while (numbers.length != 3) {
        val number = Randoms.pickNumberInRange(1, 9).toString()
        if (!numbers.contains(number)) numbers += number
    }
    return numbers.toList()
}

fun checkNumbers(numbers: List<Char>) {
    if (numbers.size != 3) {
        throw IllegalArgumentException("3자리의 수가 아닙니다.")
    }
    for (i in numbers.indices) {
        val number = Integer.parseInt(numbers[0].toString())
        if (1 > number || number > 9) throw IllegalArgumentException("숫자의 범위가 틀렸습니다")
        if (numbers.count { it == numbers[i] } > 1) throw IllegalArgumentException("세 개의 숫자가 서로 달라야 합니다")
    }
}

fun inputNumbers(): List<Char> {
    val input = Console.readLine()
    checkNumbers(input.toList())
    return input.toList()
}

fun judgeNumbers(userNumbers: List<Char>, randNumbers: List<Char>): List<Int> {
    var boll = 0
    var strike = 0

    for (i in userNumbers.indices) {
        if (userNumbers[i] == randNumbers[i]) {
            strike += 1
        } else if (randNumbers.contains(userNumbers[i])) {
            boll += 1
        }
    }
    return listOf(boll, strike)
}

fun printResult(result: List<Int>) {
    val boll = result[0]
    val strike = result[1]
    if (boll != 0) print("${boll}볼 ")
    if (strike != 0) print("${strike}스트라이크")
    if (boll == 0 && strike == 0) print("낫싱")
    println()
}

fun gameMain() {
    val randNumbers = pickNumbers()
    do {
        print("숫자를 입력해주세요 : ")
        val userNumbers: List<Char> = inputNumbers()
        val judgeResult = judgeNumbers(userNumbers, randNumbers)
        printResult(judgeResult)
    } while (judgeResult[1] != 3)
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun main() {
    var isContinue: Int
    println("숫자 야구 게임을 시작합니다.")
    do {
        gameMain()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        isContinue = Console.readLine().toInt()
        if (isContinue != 1 && isContinue != 2) throw IllegalArgumentException("1 또는 2를 입력하세요")
    } while (isContinue == 1)
}