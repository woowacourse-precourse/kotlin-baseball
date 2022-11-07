package baseball.hint

import model.Computer
import model.Player

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
    internal fun provideStrikeAndBall(): Pair<Int, Int> = Pair(strike, ball)
}