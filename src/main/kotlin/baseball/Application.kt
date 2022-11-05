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

    checkPlayerInput(readNumber)
    for (num in readNumber) {
        readList.add(num - '0')
    }

    return readList
}

fun checkPlayerInput(str: String) {
    if (str.length != 3){
        throw IllegalArgumentException("길이가 3이 아닙니다.")
    }
    for (x in str) {
        if (x !in '0'..'9') {
            throw IllegalArgumentException("범위를 벗어난 숫자입니다.")
        }
        if (str.count{it == x} != 1){
            throw IllegalArgumentException("중복된 숫자가 존재합니다.")
        }
    }
}
