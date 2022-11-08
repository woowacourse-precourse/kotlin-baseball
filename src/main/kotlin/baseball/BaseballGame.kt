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

    @Throws(IllegalArgumentException::class)
    private fun humanSelectedNumber() {
        print("숫자를 입력해주세요 : ")
        val selectedNumber = Console.readLine()
        humanPlayer.setSelectedNumber(selectedNumber)
    }

    private fun judgeHumanSelectedNumber(): String {
        val humanSelectedNumber = humanPlayer.getSelectedNumber()
        val computerSelectedNumber = computerPlayer.getSelectedNumber()
        var result = ""
        var strikeCount = 0
        var ballCount = 0

        for (idx in 0 until 3) {
            val humanSingleNumber = humanSelectedNumber[idx]
            val computerSingleNumber = computerSelectedNumber[idx]
            if (humanSingleNumber == computerSingleNumber) {
                strikeCount++
            }
        }
        if (strikeCount == 3) {
            return CORRECT_ANSWER
        }
        for (humanIdx in 0 until 3) {
            val singleNumber = humanSelectedNumber[humanIdx]
            if ((computerSelectedNumber.contains(singleNumber.toString())) &&
                (computerSelectedNumber.indexOf(singleNumber) != humanIdx)
            ) {
                ballCount++
            }
        }
        result = makeBallResult(ballCount) + makeStrikeResult(strikeCount)
        if (result.isEmpty()) {
            result = "낫싱"
        }
        println(result)
        return WRONG_ANSWER
    }

    private fun makeStrikeResult(strikeCount: Int): String {
        if (strikeCount <= 0) {
            return ""
        }
        return "${strikeCount}스트라이크"
    }

    private fun makeBallResult(ballCount: Int): String {
        if (ballCount <= 0) {
            return ""
        }
        return "${ballCount}볼 "
    }

    companion object {
        const val CORRECT_ANSWER = "3스트라이크"
        const val WRONG_ANSWER = ""
        const val RESTART_GAME = "1"
        const val TERMINATE_GAME = "2"
    }
}
