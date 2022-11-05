package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {

    val computer : MutableSet<Int> = mutableSetOf() // LinkedHashSet 생성: 순서O 중복X
    val player = mutableListOf<Int>()

    printStartMessage()
    setRandomNumber(computer)
}

fun printStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

fun setRandomNumber(com : MutableSet<Int>){
    while(com.size < 3){
        val random = Randoms.pickNumberInRange(1, 9)
        com.add(random)
    }
}


