package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer() {
    lateinit var number: List<Int>

    fun generateComputerNumber(): List<Int> {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size < NUMBER_OF_DIGITS) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber)
            }
        }
        return computerNumber
    }

    companion object{
        const val NUMBER_OF_DIGITS = 3
    }
}