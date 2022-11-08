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
    printState(0)

    compareNum()
    printState(5)
}

fun compareNum() {

    val comNum = createRandomNum()
    println("컴퓨터 리스트 : $comNum")

    while (true) {
        printState(1)
        val userNum = createUserNum()

        ballCount(userNum, comNum)
        strikeCount(userNum, comNum)
        printState(2)

        if (strikeCount == 3) break
    }

    printState(4)
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
        gameInProgress -> print("숫자를 입력해주세요 : ")
        gameScoreCount -> println("{$ballCount}볼 {$strikeCount}스트라이크")
        gameScoreNothing -> println("낫싱")
        gameEnd -> println("3개의 숫자를 모두 맞히셨습니다! 게임종료")
        gameReplay -> println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
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