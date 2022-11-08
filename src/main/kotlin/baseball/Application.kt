
package baseball

fun main() {
    val humanPlayer: Player = HumanPlayer()
    val computerPlayer: Player = ComputerPlayer(ComputerRandomNumber())
    val baseballGame = BaseballGame(humanPlayer, computerPlayer)
    baseballGame.startBaseballGame()
}
