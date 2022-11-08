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
        if (!(input == "1" || input == "2"))
            throw IllegalArgumentException()
        if (input == "2") {
            return true
        }
        computer.makeComputerList()
        return false
    }

    private fun checkBaseBall(computerList: MutableList<Int>, userList: MutableList<Int>): Boolean {
        val strike = checkStrike(computerList, userList)
        val ball = checkBall(computerList, userList) - strike

        printBaseballCount(ball, strike)
        if (strike == 3) {
            println(GAME_OVER_MESSAGE)
            println(CHECK_CONTINUE_MESSAGE)
            return checkContinue()
        }

        return false
    }

    private fun printBaseballCount(ballCount: Int, strikeCount: Int) {
        if (strikeCount == 0 && ballCount == 0)
            println(NOTING_MESSAGE)
        else if (ballCount != 0 && strikeCount == 0)
            println("$ballCount$BALL_MESSAGE")
        else if (ballCount != 0)
            print("$ballCount$BALL_MESSAGE ")
        if (strikeCount != 0)
            println("$strikeCount$STRIKE_MESSAGE")
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