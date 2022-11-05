package baseball.model

import baseball.Constants
import baseball.Validations
import camp.nextstep.edu.missionutils.Randoms

class ComputerNumber {
    fun getRandomNumbers(): List<Int> {
        val computer = mutableSetOf<Int>()
        while (computer.size < Constants.NUMBER_LENGTH) {
            val randomNumber = pickRandomNumber()
            computer.add(randomNumber)
        }
        val computerNumbers = convertSetToList(computer)
        if (!Validations.isNumberException(computerNumbers)) {
            throw IllegalArgumentException()
        }
        return computerNumbers
    }

    private fun pickRandomNumber(): Int {
        return Randoms.pickNumberInRange(1, 9)
    }

    private fun convertSetToList(computer: Set<Int>): List<Int> {
        return computer.toList()
    }
}