package baseball

import baseball.Constant.Companion.startGameMessage

fun main() {
    val computerNum = ComputerNumberCreate().computerNumber
    //println(computerNum)

    println(startGameMessage)
    PlayBaseballGame(computerNum)
}
