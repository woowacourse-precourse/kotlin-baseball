package baseball

//import camp.nextstep.edu.missionutils.Console.readLine
import baseball.Constant.Companion.errorMessage
import baseball.Constant.Companion.maxRangeString
import baseball.Constant.Companion.minRangeString


class PlayerNumberCreate {
    fun playerNumber(): MutableList<Int> {
        val playerNumber: String = inputPlayerNumber()
        constraint(playerNumber)
        return toList(playerNumber)
    }

    private fun inputPlayerNumber(): String {
        val inputNumber = readLine()
        //println("inputnumber $inputNumber")
        //constraint(inputNumber.toString())
        //return "123"
        return inputNumber.toString()
    }

    private fun constraint(inputString: String) {
        if (!inputString.all { it in minRangeString..maxRangeString } || inputString.isEmpty() || inputString.length != 3) {
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