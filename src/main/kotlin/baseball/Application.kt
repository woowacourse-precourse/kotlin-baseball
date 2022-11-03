package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    var flag = 1
    var computer: List<Int>

    while (flag == 1) {
        computer = getComputerNumber()
    }
}

fun getComputerNumber(): List<Int>{
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}
