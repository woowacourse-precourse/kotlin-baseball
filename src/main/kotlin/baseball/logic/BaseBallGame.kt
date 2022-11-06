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

    private fun playBaseballGame(computer: Computer){
        while(true) {
            user.numberFormatting(playGame.getUserNum())
            val resultArr = user.compareWithAnswer(computer.number)
            if(resultArr[0] == 3)
                if(!endBaseballGame())
                    break
            playGame.printResult(resultArr)
        }
    }

    private fun endBaseballGame(): Boolean {
        endGame.printEndGameMessage()

        val playAgainFlag = endGame.printAskPlayAgainMessage()
        if(playAgainFlag == 1)
            startBaseballGame(false)
        else (playAgainFlag == 2)
        return false
    }

}