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
        exception(userNum)
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

fun exception(userNum: CharArray) {
    if(userNum.size != 3) throw IllegalArgumentException("3자리 정수를 입력하세요.")

    userNum.forEach {
        if(it.digitToInt() !in 1 .. 9) throw IllegalArgumentException("1~9사이의 정수만 사용하세요.")
    }
}