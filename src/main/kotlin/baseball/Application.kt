package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
//    TODO("프로그램 구현")
}


/** 3개의 각각 다른 랜덤 값 생성한다. */
fun makeRandomNum(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
