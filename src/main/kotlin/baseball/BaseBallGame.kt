package baseball

import camp.nextstep.edu.missionutils.Randoms

class BaseBallGame {
    data class Score(var strike: Int, var ball: Int)

    private var score: Score = Score(0, 0)

    private var progressStatus = RUNNING
    private fun generateAnswer(): String {
        val answerList = mutableListOf<Int>()
        while (answerList.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (answerList.contains(randomNumber).not()) {
                answerList.add(randomNumber)
            }
        }
        return answerList.joinToString("")
    }

    companion object {
        private const val RUNNING = 1
        private const val RESTART = 2
        private const val END = -1
    }
}
