package baseball

import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")
    var computer: String = ""
    computer = randomNum()
    print("숫자를 입력해주세요 : ")
    val userInput = readLine()!!
    println(userInput)
    userWrongTypeAnswer(userInput)
    userWrongSizeAnswer(userInput)
}

fun randomNum(): String {
    var computer: String = ""
    while (computer.length < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber.toString())) {
            computer += randomNumber
        }
    }
    return computer
}
fun userWrongTypeAnswer(userAnswer: String) {
    try {
        Integer.parseInt(userAnswer)
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("게임 종료")
    }
}
fun userWrongSizeAnswer(userAnswer: String) {
    if (userAnswer.length != 3) throw IllegalArgumentException("게임 종료")
}
