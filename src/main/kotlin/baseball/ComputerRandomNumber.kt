package baseball

import camp.nextstep.edu.missionutils.Randoms

class ComputerRandomNumber {

    private var _randomNumber: String = ""
    val randomNumber: String
        get() = _randomNumber
    private fun makeRandomNumber(): String {
        val usedNumber = MutableList(10) { false }
        var randomNumber = ""
        while (randomNumber.length < 3) {
            val tempNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_MIN_RANGE, RANDOM_NUMBER_MAX_RANGE)
            if (usedNumber[tempNumber]) {
                continue
            }
            usedNumber[tempNumber] = true
            randomNumber += tempNumber
        }
        return randomNumber
    }

    companion object {
        const val RANDOM_NUMBER_MIN_RANGE = 1
        const val RANDOM_NUMBER_MAX_RANGE = 9
    }
}
