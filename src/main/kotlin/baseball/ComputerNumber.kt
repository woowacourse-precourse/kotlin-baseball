package baseball

import camp.nextstep.edu.missionutils.Randoms

class ComputerNumber  {
    val computerNumber: MutableList<Int> = mutableListOf()

    fun makeComputerBaseball(): List<Int> {
        while (computerNumber.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            checkOverlapInList(randomNumber, computerNumber)
        }
        return computerNumber
    }

    fun checkOverlapInList(randomNumber: Int, computerNumber: MutableList<Int>) {
        if (!computerNumber.contains(randomNumber)) {
            computerNumber.add(randomNumber)
        }
    }
}