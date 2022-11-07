package baseball

class Baseball {

    private val computer = Computer()
    private val user = User()

    init {
        playGame()
    }

    private fun playGame() {
        while (true) {
            val computerList = computer.makeComputerList()
            val userList = user.inputUser()

            checkBaseBall(computerList, userList)
        }
    }

    private fun checkBaseBall(computerList: MutableList<Int>, userList: MutableList<Int>) {
        val strike = checkStrike(computerList, userList)
        val ball = checkBall(computerList, userList) - strike


    }

    private fun checkStrike(computerList: MutableList<Int>, userList: MutableList<Int>): Int {
        var strike = 0
        for (i in 0 until userList.size) {
            if (userList[i] == computerList[i])
                strike++
        }
        return strike
    }

    private fun checkBall(computerList: MutableList<Int>, userList: MutableList<Int>): Int {
        var ball = 0
        for (i in userList) {
            if (computerList.contains(i))
                ball++
        }
        return ball
    }
}