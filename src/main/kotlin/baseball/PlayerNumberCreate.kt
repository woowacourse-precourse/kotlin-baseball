package baseball

import camp.nextstep.edu.missionutils.Console.readLine
import baseball.Constant.Companion.errorMessage
import baseball.Constant.Companion.maxRangeString
import baseball.Constant.Companion.minRangeString

class PlayerNumberCreate {
    private val printObject = PrintMethod()

    init {
        printObject.printInputMessage()
    }

    fun playerNumber(): MutableList<Int> {
        val playerNumber: String = inputPlayerNumber()
        constraint(playerNumber) // 예외처리
        return toList(playerNumber) // List 형태로 반환
    }

    private fun inputPlayerNumber(): String = readLine()

    private fun constraint(inputString: String) {
        if (!inputString.all { it in minRangeString..maxRangeString }
            || inputString.length != 3
            || checkDuple(toList(inputString))) {
            throw IllegalArgumentException(errorMessage)
        }
    }

    private fun checkDuple(inputList: MutableList<Int>): Boolean {
        return inputList.size != inputList.distinct().count()
    }

    private fun toList(playerNumber: String): MutableList<Int> {
        val toListNumber = mutableListOf<Int>()
        for (char in playerNumber) {
            toListNumber.add(char.digitToInt())
        }
        return toListNumber
    }


}