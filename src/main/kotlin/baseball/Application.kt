package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    var flag = 1
    var computer: List<Int>
    var person: List<Int>

    computer = getComputerNumbers()
    while (flag == 1) {
        person = getPlayerNumbers()
        flag = 0
    }
}

fun getComputerNumbers(): List<Int> {
    val computer: MutableList<Int> = mutableListOf()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

fun getPlayerNumbers(): List<Int> {
    val readNumber: String = Console.readLine()
    var readList: MutableList<Int> = mutableListOf()

    for (num in readNumber) {
        readList.add(num - '0')
    }

    return readList
}

