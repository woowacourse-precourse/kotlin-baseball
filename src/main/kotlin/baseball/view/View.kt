package baseball.view

import camp.nextstep.edu.missionutils.Console

class View {
    fun inputPlayerNumber(): String {
        return Console.readLine()
    }

    fun inputPlayerGoOrStop(): String {
        return Console.readLine()
    }

    fun outputMessage(message: String) {
        return print(message)
    }

    fun outputMessageAndLinebreak(message: String) {
        return println(message)
    }
}
