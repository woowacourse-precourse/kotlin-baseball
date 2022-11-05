package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class ComputerNumber {
    fun getRandomNumbers(): List<Int> {
        val computer = mutableSetOf<Int>()
        while (computer.size < 3) {
            val randomNumber = pickRandomNumber()
            computer.add(randomNumber)
        }
        return computer.toList()
    }

    private fun pickRandomNumber(): Int {
        return Randoms.pickNumberInRange(1, 9)
    }
}