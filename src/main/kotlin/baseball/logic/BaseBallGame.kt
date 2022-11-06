package baseball.logic
import baseball.view.EndGame
import baseball.view.PlayGame
import baseball.view.StartGame

class BaseBallGame {

    private val endGame = EndGame()
    private val playGame = PlayGame()
    private val startGame = StartGame()
    private val user = User()

    fun startBaseballGame(firstGame: Boolean){
        if (firstGame)
            startGame.printStartGameMessage()

        val computer = Computer()
        playBaseballGame(computer)
    }

}