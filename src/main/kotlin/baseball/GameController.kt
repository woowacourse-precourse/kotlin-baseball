package baseball

import camp.nextstep.edu.missionutils.Console
import model.Computer
import util.Constraints
import util.Messages

class GameController {
    fun gameStart() {
        while (true) {
            playNumBaseBall()
            // 성공시 재시작 여부
            if (goOrStop() == Constraints.FINISH) {
                break
            }
        }
    }

    private fun playNumBaseBall() {
        val computer = Computer()
        var com: String = computer.makeRandomNumber()

        var user: String

        println(Messages.START_GAME)

        while (true) {
            // 숫자 입력
            print(Messages.INPUT_NUMBER)
            user = Console.readLine()

            // 입력값 검증
            val regex = "^[1-9]{3}$".toRegex()
            if (regex.find(user) == null || user.toSet().size < Constraints.MAX_SIZE) {
                throw IllegalArgumentException()
            }
            // 판정
            checkStrikeOrBall(user, com)
            if (user == com) {
                println(Messages.SUCCESS)
                break
            }
        }
    }

    private fun checkStrikeOrBall(user: String, com: String) {
        var strike = 0
        var ball = 0

        for ((i, v) in user.withIndex()) {
            if (com[i] == v) {
                strike++
            } else if (v in com) {
                ball++
            }
        }
        if (ball == 0 && strike == 0) {
            println(Messages.NOTHING)
        } else if (ball == 0) {
            println("$strike" + Messages.STRIKE)
        } else if (strike == 0) {
            println("$ball" + Messages.BALL)
        } else {
            println("$ball" + Messages.BALL + " " + "$strike" + Messages.STRIKE)
        }
    }

    private fun goOrStop(): String {

        println(Messages.ASK_RESTART_OR_STOP)

        var restart = Console.readLine()

        val regex = "^[1-2]$".toRegex()
        if (regex.find(restart) == null) {
            throw IllegalArgumentException()
        }

        if (restart == Constraints.FINISH) {
            println(Messages.FINISH)
            return Constraints.FINISH
        }
        return Constraints.RESTART
    }
}