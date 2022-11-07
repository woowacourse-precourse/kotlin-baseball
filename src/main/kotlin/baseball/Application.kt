package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val computer = mutableListOf<Int>()
    val game = NumberBaseballGame()
    val exit = false

    println("숫자 야구 게임을 시작합니다.")

    while (!exit) {
        print("숫자를 입력해주세요 : ")
        val player = Console.readLine().map { it.digitToInt() }

        game.resetScore()
        game.calculateScore(computer, player)
        game.printResult()
    }
}
