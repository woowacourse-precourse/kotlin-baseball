package baseball

import camp.nextstep.edu.missionutils.Console

class UserInput {
    fun getUserInput(): List<Int> {
        PrintForm().printInputPlease()
        val input = Console.readLine()
        return Regex().checkInputRegex(input)
    }
}