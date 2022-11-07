package baseball.domain

import baseball.resources.*

class Match(
    private var ball: Int = ZERO,
    private var strike: Int = ZERO,
    private var hint: String = NULL,
) {
    private lateinit var playerNumber: String
    private lateinit var computerNumber: String
    private var ballCheck = mutableSetOf<Char>()

    fun startWith(computerNumber: String, playerNumber: String) {
        initializeScore()

        this.computerNumber = computerNumber
        this.playerNumber = playerNumber

        matchTwoPlayers()
    }

    private fun initializeScore() {
        ball = ZERO
        strike = ZERO
        hint = NULL
    }

    private fun matchTwoPlayers() {
        ballCheck.clear()

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
