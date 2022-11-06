package baseball.baseballgame

import baseball.util.createRandomNumber
import baseball.util.userInput
import camp.nextstep.edu.missionutils.Console

class Game {
    fun startGame() {
        var flag = true
        println("숫자 야구 게임을 시작합니다.")
        while (flag) {
            gameController()
            flag = newGameStart()
        }
    }

    private fun gameController() {
        val computerNum = createRandomNumber()
        var flag = false
        val list = computerNum.toList()
        while (!flag) {
            print("숫자를 입력해주세요 : ")
            flag = checkBallOrStrike(list)
        }
    }

    private fun newGameStart(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        var choice = Console.readLine().toInt()

        if (choice == 1) {
            return true
        }
        if (choice == 2) {
            return false
        }
        return throw IllegalArgumentException()
    }

    private fun checkBallOrStrike(comNumList: List<Char>): Boolean {
        val userInput = userInput()
        var ball = 0
        var strike = 0

        for (i in userInput.indices) {
            if (comNumList[i] == userInput[i]) {
                strike += 1
            } else if (comNumList.contains(userInput[i])) {
                ball += 1
            }
        }

        if (strike == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            return true
        }

        return false
    }
}