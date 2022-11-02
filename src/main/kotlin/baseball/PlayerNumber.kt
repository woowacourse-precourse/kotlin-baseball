package baseball

import camp.nextstep.edu.missionutils.Console.readLine

class PlayerNumber {
    private val playerNumber: String = readLine()
    val toListPlayerNumber = mutableListOf<Int>()

    init {
        constraint(playerNumber)
        toList(playerNumber)
    }

    private fun constraint(inputString: String){
        if (!inputString.all { it in '1'..'9'}) {
            throw IllegalArgumentException("잘못된 값을 입력했습니다 올바른 값을 입력해주세요.")
        }
    }

    private fun toList(playerNumber: String) {
        for (char in playerNumber) {
            toListPlayerNumber.add(char.digitToInt())
        }
    }


}