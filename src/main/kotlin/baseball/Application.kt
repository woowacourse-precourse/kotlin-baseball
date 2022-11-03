package baseball

import camp.nextstep.edu.missionutils.Randoms


fun main() {
    val computer = createRandomNumber()
    inputUserNumber()
}

fun createRandomNumber(): MutableList<Int> {
    val computer: MutableList<Int> = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains((randomNumber))) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun inputUserNumber(){
    println("숫자 야구 게임을 시작합니다.")
    print("숫자를 입력해주세요 : ")
    val user = readLine()
}

