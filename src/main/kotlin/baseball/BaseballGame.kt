package baseball

import camp.nextstep.edu.missionutils.Console
import java.lang.IllegalArgumentException

class BaseballGame(private val humanPlayer: Player, private var computerPlayer: Player) {

    fun startBaseballGame() {
        var restartGame = true
        println("숫자 야구 게임을 시작합니다.")
        while (restartGame) {
            humanSelectedNumber()
            if (judgeHumanSelectedNumber() == CORRECT_ANSWER) {
                restartGame = selectRestartOrTerminate()
            }
        }
    }

    companion object {
        const val CORRECT_ANSWER = "3스트라이크"
        const val WRONG_ANSWER = ""
        const val RESTART_GAME = "1"
        const val TERMINATE_GAME = "2"
    }
}
