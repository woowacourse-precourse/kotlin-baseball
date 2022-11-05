package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var flag: Boolean = true
    var computer: List<Int>
    var player: List<Int>

    println("숫자 야구 게임을 시작합니다.")
    computer = getComputerNumbers()
    println(computer)
    while (flag) {
        player = getPlayerNumbers()
        flag = checkStrike(computer, player)
    }
}

fun getComputerNumbers(): List<Int> {
    val computer: MutableList<Int> = mutableListOf()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun getPlayerNumbers(): List<Int> {
    print("숫자를 입력해주세요 : ")
    val readNumber: String = Console.readLine()
    var readList: MutableList<Int> = mutableListOf()

    checkPlayerInput(readNumber)
    for (num in readNumber) {
        readList.add(num - '0')
    }

    return readList
}

fun checkPlayerInput(str: String) {
    if (str.length != 3){
        throw IllegalArgumentException("길이가 3이 아닙니다.")
    }
    for (x in str) {
        if (x !in '0'..'9') {
            throw IllegalArgumentException("범위를 벗어난 숫자입니다.")
        }
        if (str.count{it == x} != 1){
            throw IllegalArgumentException("중복된 숫자가 존재합니다.")
        }
    }
}

fun checkStrike(computer: List<Int>, player: List<Int>): Boolean {
    var ball: Int = 0
    var strike: Int = 0

    for (i in player.indices) {
        if (player[i] !in computer)
            continue
        if (player[i] == computer[i])
            strike++
        else
            ball++
    }
    println(getResultString(ball, strike))

    if (strike == 3)
        return false
    return true
}

fun getResultString(ball: Int, strike: Int): String {
    var str: String = ""

    if (ball > 0) {
        str = when (strike) {
            0 -> "${ball}볼"
            else -> "${ball}볼 ${strike}스트라이크"
        }
    }
    if (ball == 0) {
        str = when (strike) {
            0 -> "낫싱"
            3 -> "3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
            else -> "${strike}스트라이크"
        }
    }
    return str
}