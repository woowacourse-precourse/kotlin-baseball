package baseball

import camp.nextstep.edu.missionutils.Randoms

fun gameStart() {
    println("숫자 야구 게임을 시작합니다.")
}
fun strikeRandNumCreate(): MutableList<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun main() {

}
