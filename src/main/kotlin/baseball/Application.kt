package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    print(createRandomNum())

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

fun printState(state : Int){
    when(state){
        gameStart -> println("숫자 야구 게임을 시작합니다.")
        gameInProgress -> println("숫자를 입력해주세요 : " )
    }
}

const val gameStart = 0
const val gameInProgress = 1
const val gameEnd = 2