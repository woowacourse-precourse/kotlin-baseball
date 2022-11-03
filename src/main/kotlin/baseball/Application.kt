package baseball

import baseball.Constant.Companion.startGameMessage

fun main() {
    val computerNum = ComputerNumberCreate().computerNumber
    println(computerNum)

    print(startGameMessage)
    PlayBaseballGame(computerNum)
}
