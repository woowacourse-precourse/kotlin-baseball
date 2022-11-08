package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

lateinit var computerNum: ArrayList<Int>
lateinit var userNum: Array<Int>
var chooseStartOrEnd = 1

fun main() {
    gameStart()

    while (chooseStartOrEnd == 1) {
        userInput()
    }
}

fun gameStart() {
    println("숫자 야구 게임을 시작합니다.")
    makeComputerChoose()
}

fun makeComputerChoose(): ArrayList<Int> {
    computerNum = ArrayList()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) computerNum.add(randomNumber)
    }

    return computerNum
}

fun userInput() {
    print("숫자를 입력해주세요. : ")
    userNum = splitNum(Console.readLine().toInt())
}

fun splitNum(wholeNum: Int): Array<Int> {
    val splitedNum = wholeNum.toString().chunked(1)

    return splitedNum.map { it.toInt() }.toTypedArray()
}