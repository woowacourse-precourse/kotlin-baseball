package baseball

import baseball.src.Game
import baseball.src.printStartMessage

fun main() {
    printStartMessage()
    Game().startGame()
    Game().gameRestart()
}
