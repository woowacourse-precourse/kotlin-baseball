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
            computer.number.forEach { print(it) }
            user.numberFormatting(playGame.getUserNum())
            val resultArr = user.compareWithAnswer(computer.number)
            if(resultArr[0] == 3){
                when(endBaseballGame()){
                    1 -> {startBaseballGame(false)
                        break}
                    2 -> break
                    else -> throw IllegalArgumentException()
                }
            }

            playGame.printResult(resultArr)
        }
    }

    private fun endBaseballGame(): Int {
        endGame.printEndGameMessage()

        return endGame.printAskPlayAgainMessage()
    }

}