package baseball.view

import baseball.ExceptionCheck
import camp.nextstep.edu.missionutils.Console

class Input {

    val check = ExceptionCheck()

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