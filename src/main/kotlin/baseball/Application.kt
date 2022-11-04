package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {

    generateComputer()

}

//1. 서로 다른 1- 9 사이의 수 3개 생성
fun generateComputer(): List<Int>{
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

return computer
}



