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

    fun run() {
        //게임 시작 문구
        gameStartPhrases()

        //컴퓨터에게 랜덤값 받기
        answer = computerNumber.setComputerNumber()

        //정답 입력하고 결과 확인
        playGame()


    }
    fun gameStartPhrases() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun playGame(){

        for(i in 0 until 4){
            checkResult()
        }

    }

    fun checkResult() {

        val inputNumber = input.InputAnswer()
        checkAnswer(answer, inputNumber)

        if (strike_count == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

        }

        if (nothing_count == 3) {
            println("낫싱")

        }

        val sb = StringBuilder()
        if (ball_count > 0) {
            sb.append(ball_count).append("볼 ")
        }
        if (strike_count > 0) {
            sb.append(strike_count).append("스트라이크")
        }
        println(sb)
    }

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
}
