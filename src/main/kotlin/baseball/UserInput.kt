package baseball

import camp.nextstep.edu.missionutils.Console

class UserInput {
    fun getUserInput(): List<Int> {
        print("숫자를 입력해주세요 : ")
        val input = Console.readLine()
        return Regex().checkInputRegex(input)
    }
}