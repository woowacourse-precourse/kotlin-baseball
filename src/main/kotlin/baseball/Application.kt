package baseball

import camp.nextstep.edu.missionutils.Randoms
import kotlin.math.acosh

fun main() {
    showStartMessage()

    var gameFlag = true
    while (gameFlag) {
        baseballGameStart()
        gameFlag = baseballGameEnd()
    }
}

fun baseballGameStart() {
    val computerNum = setComputerNum()
    compareUserNumAndComputerNum(computerNum)
}

fun setComputerNum(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun compareUserNumAndComputerNum(computer: List<Int>) {
    val userNum = getNum()
    var ballCount = 0
    var strikeCount = 0

    userNum.forEach {
        if (computer.contains(it))
            ballCount++
    }
    for (i in 0..2) {
        if (computer[i] == userNum[i])
            strikeCount++
    }

    ballCount -= strikeCount

    if (ballCount == 0 && strikeCount == 0)
        println("낫싱")
    else if (ballCount == 0)
        println("${strikeCount}스트라이크")
    else if (strikeCount == 0)
        println("${ballCount}볼")
    else if (ballCount != 0 && strikeCount != 0)
        println("${ballCount}볼 ${strikeCount}스트라이크")

    println(computer)

    if (strikeCount != 3) {
        compareUserNumAndComputerNum(computer)
    }


}

fun getNum(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val tempNum = readLine()!!
    var userNum: Int

    if (isInValidNum(tempNum))
        throw IllegalArgumentException("Error")
    else
        userNum = tempNum.toInt()

    val userNumList = mutableListOf<Int>()

    while (userNum != 0) {
        userNumList.add(userNum % 10)
        userNum /= 10
    }

    return userNumList.reversed()
}

fun isInValidNum(userNum: String): Boolean {
    val regex = Regex("^[1-9]{3}\$")
    if (regex.matches(userNum))
        return false

    return true
}

fun baseballGameEnd(): Boolean {
    showEndMessage()

    return when (readLine()!!.toInt()) {
        1 -> {
            true
        }

        2 -> {
            false
        }

        else -> {
            throw IllegalArgumentException("Error")
        }
    }
}

fun showStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun showEndMessage() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}