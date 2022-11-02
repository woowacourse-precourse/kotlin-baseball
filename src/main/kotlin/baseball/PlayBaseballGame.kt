package baseball

class PlayBaseballGame {
    val computerNum = ComputerNumberCreate().computerNumber
    val playerNum = PlayerNumber().toListPlayerNumber
    init {
        println(computerNum)
        println(playerNum)
    }

}