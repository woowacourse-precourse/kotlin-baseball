package baseball

import java.lang.StringBuilder

interface StringMaker {
    fun initGameStartMessage(): String
    fun inputForEachRoundMessage(): String
    fun resultCurRound(user: Any, enemy: Any): String
    fun gameClearMessage(): String
    fun gameFailedMessage(): String
    fun restartGameQuestionMessage(): String
}

class BaseballStringMaker : StringMaker {
    override fun initGameStartMessage(): String {
        return INIT_GAME_START_MESSAGE
    }

    override fun inputForEachRoundMessage(): String {
        return PLEASE_INPUT_NUMBER
    }

    override fun resultCurRound(user: Any, computer: Any): String {
        user as List<Int>
        computer as List<Int>
        val ballCount = ballCount(user, computer)
        val strikeCount = strikeCount(user, computer)
        val result = StringBuilder()
        if (ballCount != 0) result.append("$ballCount$BALL")
        if (strikeCount != 0) result.append("$strikeCount$STRIKE")
        if (ballCount == 0 && strikeCount == 0) result.append(NOTHING)
        return result.toString()
    }

    override fun gameClearMessage(): String {
        return GAME_CLEAR_MESSAGE
    }

    override fun restartGameQuestionMessage(): String {
        return RESTART_GAME_MESSAGE
    }

    private fun ballCount(user: List<Int>, computer: List<Int>): Int {
        var containsCount = 0
        val samePositionCount = strikeCount(user, computer)
        user.forEach { if (it in computer) containsCount++ }
        return containsCount - samePositionCount
    }

    private fun strikeCount(user: List<Int>, computer: List<Int>): Int {
        var samePositionCount = 0
        for (i in 0 until 3) {
            if (user[i] == computer[i]) samePositionCount++
        }
        return samePositionCount
    }

    override fun gameFailedMessage(): String {
        return ""
    }

    companion object {
        const val BALL = "볼 "
        const val STRIKE = "스트라이크 "
        const val NOTHING = "낫싱"
        const val INIT_GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다."
        const val PLEASE_INPUT_NUMBER = "숫자를 입력해주세요 : "
        const val END_CONDITION_MESSAGE = "3스트라이크 "
        const val GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
        const val RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    }
}