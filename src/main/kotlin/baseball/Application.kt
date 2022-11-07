package baseball

import baseball.game.BaseballGame
import baseball.game.Provider.pickRandomNumber
import baseball.game.Provider.readLine

fun main() {
    BaseballGame.Builder()
        .onStart(::pickRandomNumber)
        .onProgress(::readLine)
        .onFinish(::readLine)
        .build()
        .play()
}