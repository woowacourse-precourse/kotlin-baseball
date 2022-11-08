package baseball.controller

import baseball.Constant.CNT_NUMBER
import baseball.Constant.DEFAULT_NUMBER
import baseball.model.Computer

class Calculator(
    private val userInput: String,
    private val answer: String = Computer.randomNumber
) {

    lateinit var ballAndStrike: Pair<Int, Int>
        private set

    fun countBallAndStrike() {
        var ballCount = DEFAULT_NUMBER
        var strikeCount = DEFAULT_NUMBER

        userInput.forEachIndexed { index, userNum ->
            if (userNum != answer[index] &&
                answer.contains(userNum)
            ) ballCount++
        }

        repeat(CNT_NUMBER) { idx ->
            if (userInput[idx] == answer[idx]) strikeCount++
        }

        ballAndStrike = Pair(ballCount, strikeCount)
    }
}