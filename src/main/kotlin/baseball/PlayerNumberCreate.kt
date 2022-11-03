package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import baseball.Constant.Companion.errorMessage
import baseball.Constant.Companion.minRangeNum
import baseball.Constant.Companion.maxRangeNum
import baseball.Constant.Companion.newGameSwitch



class PlayerNumberCreate {
    fun playerNumber(): MutableList<Int> {
        val playerNumber: String = inputPlayerNumber()
        println(playerNumber)
        constraint(playerNumber)
        return toList(playerNumber)
    }

    private fun inputPlayerNumber(): String {
        return readLine()
    }

    private fun constraint(inputString: String) {
        if (!inputString.all { it in minRangeNum.toChar()..maxRangeNum.toChar()} || inputString.isEmpty() || inputString.length != 3) {
            throw IllegalArgumentException(errorMessage)
        }
    }

    private fun toList(playerNumber: String): MutableList<Int> {
        val toListNumber = mutableListOf<Int>()
        for (char in playerNumber) {
            toListNumber.add(char.digitToInt())
        }
        return toListNumber
    }


}