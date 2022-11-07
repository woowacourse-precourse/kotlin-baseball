package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun pickNumbers(): List<Char> {
    var numbers = ""
    for (i in 1..3) {
        numbers += Randoms.pickNumberInRange(1, 9).toString()
    }
    return numbers.toList()
}

fun inputNumbers(): List<Char> {
    val input = Console.readLine()

//    Integer.parseInt(input)
    if (input.length != 3) {
        throw IllegalArgumentException("3자리의 수가 아닙니다")
    }


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
    if (boll != 0) {
        print("${boll}볼 ")
    }
    if (strike != 0) {
        print("${strike}스트라이크")
    }
    if(boll == 0 && strike == 0) {
        print("낫싱")
    }
    println()
}

fun main() {
    var isContinue = 1

    println("숫자 야구 게임을 시작합니다.")
    do {
        val randNumbers = pickNumbers()
//        val randNumbers = "425".toList()
        println(randNumbers)
        print("숫자를 입력해주세요 : ")
        val userNumbers: List<Char> = try {
            inputNumbers()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            println("게임을 종료합니다.")
            return
        }

        val judgeResult = judgeNumbers(userNumbers, randNumbers)
        printResult(judgeResult)

        if (judgeResult[1] == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            isContinue = Console.readLine().toInt()
        }
    } while (isContinue == 1)

}
