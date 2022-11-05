package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computerNumber = createComputerNumber()
    startGame(computerNumber)
}

fun startGame(computerNumber: ArrayList<Int>) {
    var SUCCESS = false
    while (!SUCCESS) {
        print("숫자를 입력해주세요 : ")
        var userInput = readLine()?.toMutableList()
    }
}

fun createComputerNumber(): ArrayList<Int> {
    val computerNumber = ArrayList<Int>()
    while (computerNumber.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
    println("숫자 야구 게임을 시작합니다.")
    return computerNumber
}