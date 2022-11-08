package baseball

import baseball.resources.*
import baseball.domain.Computer
import baseball.domain.Match
import baseball.domain.Player
import baseball.util.RandomGenerate
import baseball.view.View
import java.lang.IllegalArgumentException

class BaseballGame {
    private val computer = Computer(RandomGenerate())
    private val player = Player()
    private val match = Match()
    private val view = View()

    fun run() {
        view.outputMessageAndLinebreak(GAME_START)
        do {
            computer.makeRandomNumbers()
            playGame()
        } while (startNewGame())
    }

    private fun playGame() {
        do {
            view.outputMessage(REQUEST_PLAYER_NUMBER)
            player.saveIfValid(view.inputPlayerNumber())
            match.startWith(computer.number, player.number)
            view.outputMessageAndLinebreak(match.printHint())
        } while (matchAllNumbers())
    }

    private fun startNewGame(): Boolean {
        view.outputMessageAndLinebreak(NEW_GAME_START_OR_GO)
        return when (view.inputPlayerGoOrStop()) {
            RESTART -> true
            QUIT -> false
            else -> throw IllegalArgumentException(INPUT_VALUE_ONE_OR_TWO_ONLY)
        }
    }

    private fun matchAllNumbers(): Boolean {
        return if (computer.number == player.number) {
            view.outputMessageAndLinebreak(GAME_STOP)
            STOP
        } else RETRY
    }
}
