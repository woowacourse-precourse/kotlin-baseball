package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import common.Constant


fun main() {
    var exitFlag = false
    while (!exitFlag) {
        exitFlag = startBaseballGame()
    }
    println("게임 종료")
}

fun startBaseballGame(): Boolean {
    val com = getComInput()
    while (true) {
        val user = getUserInput().map { it - '0' }.toList()
        if (user.isEmpty()) {
            return true
        }
        val gameRes = compareUserAndCom(user, com)
        val ballCnt = gameRes[0]
        val strikeCnt = gameRes[1]
        val gameFinishFlag = displayResult(strikeCnt, ballCnt)
        if (gameFinishFlag) {
            return restartOrExit()
        }
    }
}

fun compareUserAndCom(user: List<Int>, com: List<Int>): MutableList<Int> {
    val res = mutableListOf(0, 0)
    var strikeCnt = 0
    var ballCnt = 0
    for (i in user.indices) {
        when (checkBallOrStrike(i, user[i], com)) {
            "Strike" -> strikeCnt++
            "Ball" -> ballCnt++
            else -> {}
        }
    }
    res[0] = ballCnt
    res[1] = strikeCnt
    return res
}

fun restartOrExit(): Boolean {
    val userAnswer = Console.readLine()
    return userAnswer == "2"
}

fun displayResult(strikeCnt: Int, ballCnt: Int): Boolean {
    return if (strikeCnt == 0 && ballCnt == 0) {
        println("낫싱")
        false
    } else if (strikeCnt == 3) {
        println("3스트라이크")
        true
    } else {
        println("${ballCnt}볼 ${strikeCnt}스트라이크")
        false
    }
}

fun checkBallOrStrike(i: Int, num: Int, com: List<Int>): String {
    for (j in com.indices) {
        return if (com[j] == num && j == i) {
            "Strike"
        } else if (com[j] == num) {
            "Ball"
        } else continue
    }
    return "Nothing"
}

fun getComInput(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun getUserInput(): String {
    val input = Console.readLine()
    return if (userInputValidation(input)) {
        input
    } else {
        ""
    }


}

fun userInputValidation(input: String): Boolean {


    checkIncludeZero(input)
    checkInputLength(input)
    checkDuplicateNum(input)
    checkOnlyNumber(input)
    return true

        /* 예외처리
    try {
        checkIncludeZero(input)
        checkInputLength(input)
        checkDuplicateNum(input)
        checkOnlyNumber(input)
    } catch (e: java.lang.IllegalArgumentException) {
        return false
    }
    return true
    */

}

fun checkIncludeZero(input: String) {
    if (input.contains("0")) {
        throw IllegalArgumentException(Constant.INVALID_ZERO_INCLUDE_ERROR)
    }
}

fun checkInputLength(input: String) {
    if (input.length != 3) {
        throw IllegalArgumentException(Constant.INVALID_LENGTH_ERROR)
    }
}

fun checkDuplicateNum(input: String) {
    if (input.toList().distinct().size != 3) {
        throw IllegalArgumentException(Constant.INVALID_DUPLICATE_NUM_ERROR)
    }
}

fun checkOnlyNumber(input: String) {
    val regexOnlyNumber = Regex("-?\\d+(\\.\\d+)?")
    if (!regexOnlyNumber.matches(input)) {
        throw IllegalArgumentException(Constant.INVALID_NOT_ONLY_NUMBER_ERROR)
    }
}