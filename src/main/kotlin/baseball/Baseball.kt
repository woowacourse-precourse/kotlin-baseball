package baseball

class Baseball {

    private val computer = Computer()

    init{
        playGame()
    }

    private fun playGame() {
        while(true){
            val computerList = computer.makeComputerList()
        }
    }
}