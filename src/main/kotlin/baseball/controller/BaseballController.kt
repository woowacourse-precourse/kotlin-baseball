package baseball.controller

import baseball.model.ComputerNumber
import baseball.view.Input

class BaseballController {

    val computerNumber = ComputerNumber()
    val input = Input()
    lateinit var answer: String
    var nothing_count = 0
    var ball_count = 0
    var strike_count = 0
    var exit = false

    fun run() {

        input.gameStartPhrases()

        //컴퓨터에게 랜덤값 받기
        answer = computerNumber.setComputerNumber()

        while (!exit) {
            resetResult()

            val inputNumber = input.InputAnswer()
            checkAnswer(answer, inputNumber)
            checkResult()
            restart()
        }
    }

    //스트라이크 , 볼 , 낫싱 카운트를 초기화
    fun resetResult() {
        strike_count = 0
        ball_count = 0
        nothing_count = 0
    }

    //입력에 대한 결과를 출력하는 함수
    fun checkResult() {
        val sb = StringBuilder()

        if (strike_count == 3) {
            println("3스트라이크")
            println(input.endGame)

        }
        if (nothing_count == 3) {
            println(input.nothing)
        }

        if (ball_count > 0) {
            sb.append(ball_count).append(input.ball)
        }
        if (strike_count > 0 && strike_count != 3) {
            sb.append(strike_count).append(input.strike)
        }
        println(sb)
    }

    //입력에 대해 카운트를 계산하는 함수
    fun checkAnswer(answer: String, input: String) {

        for (i in 0 until answer.length) {

            if (!answer.contains(input[i])) {
                nothing_count++
            }

            if (answer.contains(input[i]) && (answer[i] != input[i])) {
                ball_count++
            }

            if (answer.contains(input[i]) && (answer[i] == input[i])) {
                strike_count++
            }
        }
    }
    //종료 후 재 시작 여부를 묻는 함수
    fun restart() {
        if (strike_count == 3) {

            var restartNum = input.InputRestart()

            if (restartNum == "1") {
                answer = computerNumber.setComputerNumber()
            }

            if (restartNum == "2") {
                exit = true
            }
        }
    }
}
