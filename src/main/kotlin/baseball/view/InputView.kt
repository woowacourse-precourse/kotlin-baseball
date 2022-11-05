package baseball.view

import camp.nextstep.edu.missionutils.Console


class InputView {
    fun startPlayerNumber(): String {
        return Console.readLine()
    }

    fun endPlayerNumber(): String {
        return Console.readLine()
    }
}