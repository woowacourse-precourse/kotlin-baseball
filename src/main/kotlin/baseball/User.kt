package baseball

import camp.nextstep.edu.missionutils.Console

class User {

    fun getGuessInput(): List<Int> {
        val input = Console.readLine()
        // TODO 예외 사항 체크
        return input.toList().map { it.code.plus(-48) }
    }
}