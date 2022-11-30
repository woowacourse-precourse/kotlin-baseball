package baseball.model

import baseball.util.*

class AnswerBoard {
    private val stateList = MutableList(MAX_SIZE) { BaseballState.OUT }

    // ( Triple, Pair ) 반환값이 3, 2개 할때 유용
    private fun countState(): Triple<Int, Int, Int> {
        var strikeCount = 0
        var ballCount = 0
        var outCount = 0
        stateList.forEach { state ->
            when (state) {
                BaseballState.STRIKE -> strikeCount++
                BaseballState.BALL -> ballCount++
                BaseballState.OUT -> outCount++
            }
        }
        return Triple(strikeCount, ballCount, outCount)
    }

    // 스트라이크, 볼, 아웃을 넣는 기능
    fun createResult(computerInput: String, userInput: String) {
        // 컴퓨터의 입력 숫자에 각각 접근하여 비교
        computerInput.forEachIndexed { computerIndex, computerNumber ->
            // 스트라이크 일 때 조건
            if (computerNumber == userInput[computerIndex]) {
                stateList[computerIndex] = BaseballState.STRIKE
            }
            // 볼일 때 조건
            if (computerNumber != userInput[computerIndex] && userInput.contains(computerNumber)) {
                stateList[computerIndex] = BaseballState.BALL
            }
            // 아웃일 때 조건
            if (computerNumber != userInput[computerIndex] && !userInput.contains(computerNumber)) {
                stateList[computerIndex] = BaseballState.OUT
            }
        }
    }

    // 스트라이크, 볼, 아웃에 해당하는 출력하는 기능
    fun printResult(): String {
        val (strikeCount, ballCount, outCount) = countState()
        var message = ""

        // 볼, 스트라이크 2개 0일 때
        if (outCount == stateList.size) message = PRINT_NOTHING_MESSAGE
        // 볼이 0이고, 스트라이크가 0이 아닐때
        if (ballCount == 0 && strikeCount != 0) message = PRINT_STRIKE_MESSAGE.format(strikeCount)
        // 볼이 0이 아니고, 스트라이크가 0일 때
        if (ballCount != 0 && strikeCount == 0) message = PRINT_BALL_MESSAGE.format(ballCount)
        // 볼, 스트라이크 둘다 0이 아닐 때
        if (ballCount != 0 && strikeCount != 0) message =
            PRINT_STRIKE_BALL_MESSAGE.format(ballCount, strikeCount)

        return message
    }

    // 스트라이크가 모두 3개일 때
    fun isThreeStrike(): Boolean =
        stateList.all { baseballState: BaseballState -> baseballState == BaseballState.STRIKE }

    // 상태를 초기화 할때
    fun clearState() = stateList.replaceAll { BaseballState.OUT }
}
