package controller

import domain.Computer
import domain.Player
import view.InputView
import view.OutputView

class Controller {
    private val outputView = OutputView()
    private val inputView = InputView()
    private val player = Player()
    private val computer = Computer()

    fun game(){
        outputView.showStart()
        ballOrStrike(computer.makeRandomList())
    }

    fun ballOrStrike(computer : List<Int>){
        while(true){
            println(computer)
            inputView.showInput()
            val playerList = player.makeNumList()
            val pairInfo = player.compareList(computer, playerList)
            outputView.showBaseballMessage(pairInfo)

        }
    }
}