package baseball.logic
import baseball.view.EndGame
import baseball.view.PlayGame
import baseball.view.StartGame

class BaseBallGame {

    private val endGame = EndGame()
    private val playGame = PlayGame()
    private val startGame = StartGame()
    private val user = User()
    
    private var GAME = true

    init {
        startGame.printStartGameMessage()
    }

    fun startBaseballGame(){
        while (GAME){
            val computer = Computer()
            playBaseballGame(computer)

            endBaseballGame()
        }
    }

    private fun playBaseballGame(computer: Computer){
        while(GAME) {

            user.numberFormatting(playGame.getUserNum())
            val resultArr = user.compareWithAnswer(computer.number)

            playGame.printResult(resultArr)
            if(resultArr[0] == 3)
                break
        }
    }

    private fun endBaseballGame(){
        endGame.printEndGameMessage()
        GAME = when(endGame.printAskPlayAgainMessage()){
            1 -> true
            2 -> false
            else -> throw IllegalArgumentException()
        }
    }

}