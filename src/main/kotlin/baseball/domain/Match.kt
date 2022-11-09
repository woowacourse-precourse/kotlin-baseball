package baseball.domain

import baseball.resources.*

class Match(
    private var ball: Int = ZERO,
    private var strike: Int = ZERO,
    private var hint: String = NULL,
) {

    fun startWith(computerNumber: String, playerNumber: String) {
        initializeScore()
        matchTwoPlayers(computerNumber, playerNumber)
    }

    private fun initializeScore() {
        ball = ZERO
        strike = ZERO
        hint = NULL
    }

    private fun matchTwoPlayers(computerNumber: String, playerNumber: String) {
        val ballCheck = mutableSetOf<Char>()

        playerNumber.forEachIndexed { index, number ->
            if (number == computerNumber[index]) {
                strike++
                return@forEachIndexed
            }
            if (computerNumber.contains(number))
                ballCheck.add(number)
        }
        ball = ballCheck.size

        createHint()
    }

    private fun createHint() {
        if (isNotMatchingAllNumbers(ball, strike)) {
            concatenateHints(ZERO, NOTHING)
            return
        }
        if (isNotNumberZero(ball))
            concatenateHints(score = ball, judgment = BALL)
        if (isNotNumberZero(strike))
            concatenateHints(score = strike, judgment = STRIKE)
    }

    private fun concatenateHints(score: Int, judgment: String) {
        hint = when (score) {
            0 -> judgment
            else -> hint.plus(score).plus(judgment)
        }
    }

    private fun isNotNumberZero(number: Int): Boolean {
        return number != ZERO
    }

    private fun isNotMatchingAllNumbers(ball: Int, strike: Int): Boolean {
        return ball == ZERO && strike == ZERO
    }

    fun printHint(): String {
        return hint
    }
}
