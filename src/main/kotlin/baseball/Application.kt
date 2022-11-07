package baseball

import baseball.game.BaseballGame
import baseball.game.Game

private val baseballGame: Game by lazy {
    BaseballGame()
}

fun main() {
    baseballGame.start()
}