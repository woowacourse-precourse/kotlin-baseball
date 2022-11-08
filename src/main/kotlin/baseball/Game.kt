package baseball

import camp.nextstep.edu.missionutils.Console

class Game() {
    private val gamePrinter = Printer()
    private val computer = Computer()
    private val user = User()
    private val referee = Referee()

    fun play() {
        var isGamePlaying: Boolean = true
        while (isGamePlaying) {
            standbyPhase()
            mainPhase()
            endPhase().also { isGamePlaying = it }
        }
    }

    private fun standbyPhase() {
        gamePrinter.showStart()
        computer.createNumbers()
    }

    private fun mainPhase() {
        var isGamePlaying: Boolean = true
        while (isGamePlaying) {
            gamePrinter.showInputRequest()
            user.enterNumbers()

            val refereeDecision = referee.decideGameEnd(computer.computerNumbers, user.userNumbers)
            gamePrinter.showCounting(refereeDecision.ballCount, refereeDecision.strikeCount)

            isGamePlaying = !refereeDecision.isStrikeOut
        }
    }

    private fun endPhase(): Boolean {
        gamePrinter.showEnd()
        return when (Console.readLine()) {
            CONTINUE -> true
            FINISH -> false
            else -> throw IllegalArgumentException("1, 2가 아닌 다른 수가 입력되었습니다.")
        }
    }

    companion object {
        const val CONTINUE = "1"
        const val FINISH = "2"
    }
}
