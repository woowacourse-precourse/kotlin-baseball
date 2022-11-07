package baseball

import camp.nextstep.edu.missionutils.Console

class Baseball {

    private val computer = Computer()
    private val user = User()

    init {
        playGame()
    }

    private fun playGame() {
        computer.makeComputerList()
        while (true) {
            val userList = user.inputUser()

            if (checkBaseBall(computer.computerList, userList))
                break;

        }
    }

    private fun checkContinue(): Boolean {
        val input = Console.readLine()
        if(input=="2") {
            return true
        }
        computer.makeComputerList()
        return false
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
            if (strike == 3) {
                println(CHECK_CONTINUE_MESSAGE)
                return checkContinue()
            }
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