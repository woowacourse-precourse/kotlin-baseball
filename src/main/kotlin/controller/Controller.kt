package controller

import domain.Computer
import user.Player
import view.InputView
import view.OutputView

class Controller {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val player = Player()
    private val computer = Computer()

    fun game(){
        outputView.showStart()
        inputView.showInput()
        ballOrStrike(computer.makeRandomList())
    }

    private fun ballOrStrike(computerList : List<Int>){
        while(true){
            println(computerList)
            val playerList = player.makeNumList()
            val strikeBall = computer.compareList(computerList, playerList)
            outputView.showBaseballMessage(strikeBall)
            if (computer.validateGameEnd(strikeBall.first)){
                outputView.showGameEnd()
                gameRestartOrFinish()
            }
        }
    }

    private fun gameRestartOrFinish(){
        inputView.showRestartOrFinish()
        player.chooseRestartOrEnd()

    }
}