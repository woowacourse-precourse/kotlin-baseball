package baseball

import camp.nextstep.edu.missionutils.Console
import utils.Constants

class Game {
    private val display = Display()
    private val rule = Rule()
    fun start(computer: List<Int>): Boolean {
        val hint = Hint(computer)
        while (hint.strikeNum != 3) {
            display.printRequireInputNumber()
            val player = inputPlayerNumber()

            hint.calculateStrike(player)
            hint.calculateBall(player)
            display.printBallNStrike(hint)
        }

        return choiceGameRestartOrOver()
    }

    private fun inputPlayerNumber(): String {
        val input = Console.readLine()
        return when (rule.isCorrectNumber(input)) {
            true -> input
            false -> throw IllegalArgumentException()
        }
    }

    private fun choiceGameRestartOrOver(): Boolean {
        display.printGameOver()
        return when (Console.readLine()) {
            Constants.RESTART -> true
            Constants.GAME_OVER -> false
            else -> throw IllegalArgumentException()
        }
    }
}