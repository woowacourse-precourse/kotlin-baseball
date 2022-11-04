package baseball.hint

import domain.Computer
import domain.Player

abstract class Hint(
    protected val computer: Computer,
    protected val player: Player
) {
    private var strike = 0
    private var ball = 0

    init {
        calculate()
    }

    abstract fun print()

    protected abstract fun calculate()

    protected fun plusStrike() = strike++

    protected fun plusBall() = ball++

    protected fun provideStrikeAndBall(): Pair<Int, Int> = Pair(strike, ball)

}