package baseball.model

import baseball.Constants
import camp.nextstep.edu.missionutils.Randoms

class ComputerNumber {
    fun getRandomNumbers(): List<Int> {
        val computer = mutableSetOf<Int>()
        while (computer.size < Constants.NUMBER_LENGTH) {
            val randomNumber = pickRandomNumber()
            computer.add(randomNumber)
        }
        return convertSetToList(computer)
    }

    private fun pickRandomNumber(): Int {
        return Randoms.pickNumberInRange(1, 9)
    }

    private fun convertSetToList(computer: Set<Int>): List<Int> {
        return computer.toList()
    }
}