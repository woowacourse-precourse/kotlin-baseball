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



}