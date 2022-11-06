package baseball.domain

import baseball.resources.*

class Match(
    private var ball: Int = ZERO,
    private var strike: Int = ZERO,
    private var hint: String = NULL
) {
    private lateinit var playerNumber: String
    private lateinit var computerNumber: String
    private var computerBallCheckList = mutableSetOf<Char>()

    fun startWith(computerNumber: String, playerNumber: String) {
        initScore()

        this.computerNumber = computerNumber
        this.playerNumber = playerNumber
        matchTwoPlayers()
    }

    private fun initScore() {
        ball = ZERO
        strike = ZERO
        hint = NULL
    }

    private fun matchTwoPlayers() {
        computerBallCheckList.clear()

        playerNumber.forEachIndexed { index, number ->
            if (number == computerNumber[index]) {
                strike++
                return@forEachIndexed
            }
            if (computerNumber.contains(number))
                computerBallCheckList.add(number)
        }

        ball = computerBallCheckList.size
        createHint()
    }

    private fun createHint() {
        if (checkNoMatchingNumber(ball, strike)) {
            concatenateHints(ZERO, NOTHING)
            return
        }
        if (isNotNumberZero(ball)) concatenateHints(ball, BALL)
        if (isNotNumberZero(strike)) concatenateHints(strike, STRIKE)
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
    private fun checkNoMatchingNumber(ball: Int, strike: Int): Boolean {
        return ball == ZERO && strike == ZERO
    }

    fun printHint(): String {
        return hint
    }
}
