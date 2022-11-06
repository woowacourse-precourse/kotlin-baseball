package baseball.baseballgame

import camp.nextstep.edu.missionutils.Console

class Game {
    fun newGameStart(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        var choice = Console.readLine().toInt()

        if (choice == 1) {
            return true
        }
        if (choice == 2) {
            return false
        }
        return throw IllegalArgumentException()
    }
}