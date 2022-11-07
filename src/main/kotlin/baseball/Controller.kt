package baseball

import camp.nextstep.edu.missionutils.Randoms

class Controller {
    private val view = View()
    private var user = User()
    private var computer = mutableListOf<Int>()
    private val reStart = 1
    private val gameClose = 2


    fun gameStart() {
        generateComputer()
        view.printStart()
        playGame()
    }

    private fun playGame() {
        while (user.inputData != gameClose) {
            view.printInput()
            user.inputNum = getInputFormUser()
            verificationNumber(user.inputNum)
            countingStrikeBall(computer, user.intputToList())
            printResult()
            if (user.strike == 3) {
                askStartOrEnd()
            }
        }
    }

    private fun askStartOrEnd() {
        view.printStartOrEnd()
        user.inputData = getInputFormUser()
        verificationQuitNumber(user.inputData)
        if (user.inputData == reStart) {
            computer.clear()
            generateComputer()
        }
    }


    private fun generateComputer(): Unit {

        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }

    }

    private fun getInputFormUser(): Int {
        return readLine()!!.toInt()
    }

    private fun verificationNumber(inputNum: Int): Unit {
        if (inputNum !in 100..999) {
            throw IllegalArgumentException("User entered an incorrect value")
        }
    }

    private fun countingStrikeBall(computer: List<Int>, inputNum: List<Int>): Unit {
        user.strike = 0
        user.ball = 0
        for (i in 0..2) {
            user.strike += increaseStrike(computer, i, inputNum)
            user.ball += increaseBall(computer, i, inputNum)
        }


    }

    private fun increaseStrike(computer: List<Int>, comIndex: Int, inputNum: List<Int>): Int {
        var result = 0
        if (computer[comIndex] == inputNum[comIndex]) {
            result++
        }
        return result
    }

    private fun increaseBall(computer: List<Int>, comIndex: Int, inputNum: List<Int>): Int {
        var result = 0
        if (computer[comIndex] == inputNum[0] && comIndex != 0) {
            result++
        }

        if (computer[comIndex] == inputNum[1] && comIndex != 1) {
            result++
        }

        if (computer[comIndex] == inputNum[2] && comIndex != 2) {
            result++
        }
        return result
    }

    private fun printResult(): Unit {
        val strike: Int = user.strike
        val ball: Int = user.ball
        if (strike > 0 || ball > 0) {
            if (ball != 0) {
                view.printball(ball)
            }
            if (strike != 0) {
                view.printStrike(strike)
            }
            view.ln()

        }
        if (strike == 3) {
            view.printGameOver()
        }
        if (strike == 0 && ball == 0) {
            view.printNothing()
        }

    }

    private fun verificationQuitNumber(quitNum: Int): Unit {
        if (quitNum !in 1..2) {
            throw IllegalArgumentException("User entered an incorrect value")
        }
    }
}