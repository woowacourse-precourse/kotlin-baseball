package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {

}
fun computerNumber(): MutableList<Int> {
    // 1부터 9까지의 랜덤한 3가지 수 생성
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    // println("computer Input 값 : $computer")
    return computer
}
