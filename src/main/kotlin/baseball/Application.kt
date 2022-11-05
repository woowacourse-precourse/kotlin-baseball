package baseball

import camp.nextstep.edu.missionutils.Randoms

fun inputNumber(): String? {//숫자 입력
    print("숫자를 입력해주세요 : ")
    val inputNumber = readLine()//string

    return inputNumber
}
fun createRandomNumber(): String{ //랜덤 숫자 생성
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer.joinToString("")
    println(computer.toString())
}
fun main() {
    println(inputNumber())
}
