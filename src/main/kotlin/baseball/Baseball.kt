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

            if (checkBaseBall(computerList, userList))
                break;
        }
    }

    private fun checkBaseBall(computerList: MutableList<Int>, userList: MutableList<Int>): Boolean {
        val strike = checkStrike(computerList, userList)
        val ball = checkBall(computerList, userList) - strike

        if (strike == 0 && ball == 0)
            println(NOTING_MESSAGE)
        else {
            if (ball != 0)
                println("$ball$BALL_MESSAGE ")
            if (strike != 0)
                println("$strike$STRIKE_MESSAGE")
            
        }
        return false
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