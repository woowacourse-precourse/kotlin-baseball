package baseball

import camp.nextstep.edu.missionutils.*

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    do {
        val computerNumber = make3RandomNumber()


fun make3RandomNumber(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
}
