package baseball

import baseball.resources.*
import baseball.domain.Computer
import baseball.domain.Match
import baseball.domain.Player
import baseball.view.View
import java.lang.IllegalArgumentException

class BaseballGame(private val computer: Computer, private val player: Player) {
    private val match = Match()

    fun run() {
        View.outputMessageAndLinebreak(GAME_START)
        do {
            computer.makeRandomNumbers()
            playGame()
        } while (startNewGame())
    }

    private fun playGame() {
        do {
            View.outputMessage(REQUEST_PLAYER_NUMBER)
            player.saveIfValid(View.inputPlayerNumber())
            match.startWith(computer.number, player.number)
            View.outputMessageAndLinebreak(match.printHint())
        } while (matchAllNumbers())
    }

    private fun startNewGame(): Boolean {
        View.outputMessageAndLinebreak(NEW_GAME_START_OR_GO)
        return when (View.inputPlayerGoOrStop()) {
            RESTART -> true
            QUIT -> false
            else -> throw IllegalArgumentException(INPUT_VALUE_ONE_OR_TWO_ONLY)
        }
    }

    private fun matchAllNumbers(): Boolean {
        return if (computer.number == player.number) {
            View.outputMessageAndLinebreak(GAME_STOP)
            STOP
        } else RETRY
    }
}
