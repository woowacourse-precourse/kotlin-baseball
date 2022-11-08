package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class NumberBaseballGame {
    private var strike = 0
    private var ball = 0
    private var exit = false
    private val inputVerifier = InputVerifier()

    fun start(computer: MutableList<Int>) {
        println("숫자 야구 게임을 시작합니다.")

        pickRandomNumber(computer)

        while (!exit) {
            print("숫자를 입력해주세요 : ")
            val player = getPlayerInput()

            resetScore()
            calculateScore(computer, player)
            printResult()

            if (strike == 3) {
                gameOver(computer)
            }
        }
    }

    private fun pickRandomNumber(computer: MutableList<Int>) {
        while (computer.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
    }

    private fun getPlayerInput(): List<Int> {
        val input = Console.readLine().map { it.digitToInt() }
        return inputVerifier.playerNumber(input)
    }

    private fun resetScore() {
        strike = 0
        ball = 0
    }

    private fun calculateScore(computer: List<Int>, player: List<Int>) {
        computer.forEachIndexed { i, computerNumber ->
            partOfCalculate(player, i, computerNumber)
        }
    }

    private fun partOfCalculate(player: List<Int>, index: Int, number: Int) {
        player.forEachIndexed { i, playerNumber ->
            if ((number == playerNumber) && (index == i)) {
                strike += 1
            }
            if ((number == playerNumber) && (index != i)) {
                ball += 1
            }
        }
    }

    private fun printResult() {
        if (strike == 0 && ball == 0) {
            println("낫싱")
        }
        if (strike == 0 && ball != 0) {
            println("${ball}볼")
        }
        if (strike != 0 && ball == 0) {
            println("${strike}스트라이크")
        }
        if (strike != 0 && ball != 0) {
            println("${ball}볼 ${strike}스트라이크")
        }
    }

    private fun gameOver(computer: MutableList<Int>) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

        when (getExitInput()) {
            1 -> {
                computer.clear()
                pickRandomNumber(computer)
            }

            2 -> {
                exit = true
            }
        }
    }

    private fun getExitInput(): Int {
        val input = Console.readLine().toInt()
        return inputVerifier.exitNumber(input)
    }
}
