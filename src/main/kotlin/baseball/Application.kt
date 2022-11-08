package baseball

import camp.nextstep.edu.missionutils.Randoms

const val gameStart = 0
const val gameInProgress = 1
const val gameScoreCount = 2
const val gameScoreNothing = 3
const val gameEnd = 4
const val gameReplay = 5
var ballCount = 0
var strikeCount = 0


fun main() {

    val comNum = createRandomNum()
    val userNum = createUserNum()


    printState(1)
    println(createRandomNum())
    println(createUserNum())
    println(ballCount(userNum, comNum))
    println(strikeCount(userNum, comNum))
}

fun createRandomNum(): MutableList<Int> {
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }
    return computerNum
}

fun printState(state: Int) {
    when (state) {
        gameStart -> println("숫자 야구 게임을 시작합니다.")
        gameInProgress -> println("숫자를 입력해주세요 : ")
    }
}

fun createUserNum(): List<Int> {
    return readLine()!!.map { it.digitToInt() }
}

fun ballCount(userNum: List<Int>, comNum: List<Int>) {
    ballCount = 0

    for (element in userNum) {
        if (comNum.contains(element)) {
            ballCount++
        }
    }
}

fun strikeCount(userNum: List<Int>, comNum: List<Int>) {
    strikeCount = 0

    for (index in userNum.indices) {
        if (userNum[index] == comNum[index]) {
            strikeCount++
            ballCount--
        }
    }
}