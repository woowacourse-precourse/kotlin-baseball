package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    printState(1)
    println(createRandomNum())
    println(createUserNum())

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

//fun createUserNumList(userNum: Int?): MutableList<Int> {
//    var userNum = userNum
//    val userNumList = mutableListOf<Int>()
//
//    while (userNum != 0 && userNum != null) {
//        userNumList.add(userNum % 10)
//        userNum /= 10
//    }
//
//    return userNumList
//}

const val gameStart = 0
const val gameInProgress = 1
const val gameEnd = 2