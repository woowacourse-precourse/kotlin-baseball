package baseball

class Baseball {

    private val computer = Computer()
    private val user = User()

    init{
        playGame()
    }

    private fun playGame() {
        while(true){
            val computerList = computer.makeComputerList()
            val userList = user.inputUser()
        }
    }
}