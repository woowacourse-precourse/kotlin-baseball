package baseball

import camp.nextstep.edu.missionutils.Console
import utils.Constants

class Game() {
    private val display = Display()
    fun start(computer: List<Int>): Boolean {
        val hint = Hint(computer)

        while (hint.strikeNum != 3) {
            display.printRequireInputNumber()
            val player = Console.readLine()
            if (!isCorrectNumber(player)) {
                throw IllegalArgumentException()
            }

            hint.calculateStrike(player)
            hint.calculateBall(player)
            display.printBallNStrike(hint)
        }
        // 게임 재시작 or 완전히 종료 선택
        return choiceGameRestart()
    }

    fun isCorrectNumber(player: String): Boolean {
        // 1. 3자리 수가 아닐 경우 false
        if (player.length != 3)
            return false
        // 2. 1-9의 범위를 벗어난 숫자가 아닐 경우 false
        for (c in player) {
            if (c < '0' || c > '9')
                return false
        }
        // 3. 서로 다른 수를 입력하지 않았을 경우 (=중복된 수를 입력할 경우) false
        if (player[0] == player[1] || player[0] == player[1] ||
            player[1] == player[2]
        )
            return false

        return true
    }

    fun choiceGameRestart(): Boolean {
        display.printGameOver()
        return when (Console.readLine()) {
            Constants.RESTART -> true
            Constants.GAME_OVER -> false
            else ->
                throw IllegalArgumentException()
        }
    }

}