package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    while(true) {
        playGame()
    }
}

fun playGame() {
    val computerNum = randomComputerNum()

    while (true) {
        print("숫자를 입력해주세요 : ")
        val userNum = Console.readLine().toCharArray()
    }
}

fun randomComputerNum(): MutableList<Int> {
    val computerNum = mutableListOf<Int>()
    while (computerNum.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computerNum.contains(randomNumber)) {
            computerNum.add(randomNumber)
        }
    }

    return computerNum
}