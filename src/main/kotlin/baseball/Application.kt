package baseball

import camp.nextstep.edu.missionutils.Randoms

fun printStartMessage(){
    println("숫자 야구 게임을 시작합니다")
}

fun createComputerAnswer(){
    val computer = mutableListOf<Int>()
    while (computer.count() < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    println(computer)
}

fun inputUserNumber(){
    print("숫자를 입력해주세요 : ")
    val number = readLine()
    println(number)
}

fun main() {
    printStartMessage()
    createComputerAnswer()
    inputUserNumber()
}
