package baseball

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

fun main() {
    printPlayBallText()
    playBall()
}

fun playBall() {
    val computerNumber = setComputerNumber()
    while (true) {
        printInputUserNumber()
        val userNumber = inputUserNumber()
    }
}

fun inputUserNumber(): String = Console.readLine()


fun setComputerNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }
    return computer
}

fun printPlayBallText() = println("숫자 야구 게임을 시작합니다.")

fun printInputUserNumber() = print("숫자를 입력해 주세요 : ")
