package baseball.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun readNumbers(): List<Int> {
        val input = Console.readLine()
        return input.map { it.toString().toInt() }.toMutableList()
    }

    fun readRetry():Int{
        val input = Console.readLine().toInt()
        return input
    }
}