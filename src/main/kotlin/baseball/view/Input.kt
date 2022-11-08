package baseball.view

import baseball.ExceptionCheck
import camp.nextstep.edu.missionutils.Console

class Input {

    val check = ExceptionCheck()
    val endGame = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"
    val ball = "볼 "
    val nothing = "낫싱"
    val strike = "스트라이크"
    //게임 시작 문구
    fun gameStartPhrases() {
        println("숫자 야구 게임을 시작합니다.")
    }

    fun InputAnswer() : String{
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine()

        check.checkDigit(input)
        check.checkOverlap(input)
        check.checkHaveZero(input)

        return input
    }

    fun InputRestart() : String {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val input = Console.readLine()

        check.checkRestart(input)
        return input
    }



}