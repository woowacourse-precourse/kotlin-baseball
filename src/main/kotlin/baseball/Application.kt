package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computer = mutableListOf<Int>()
    val game = NumberBaseballGame()

    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    println("숫자 야구 게임을 시작합니다.")

    print("숫자를 입력해주세요 : ")
    val player = Console.readLine().map { it.digitToInt() }

    game.calculateScore(computer, player)
    game.printResult()
}
