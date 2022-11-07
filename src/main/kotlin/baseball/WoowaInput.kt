package baseball

import camp.nextstep.edu.missionutils.Console

class WoowaInput : Input {
    override fun get(): String {
        val userInput = Console.readLine()
        println(userInput)
        return userInput
    }
}