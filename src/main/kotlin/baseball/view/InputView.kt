package baseball.view

import camp.nextstep.edu.missionutils.Console


class InputView {
    fun startPlayerNumber(): String = Console.readLine()
    fun endPlayerNumber(): String = Console.readLine()
}