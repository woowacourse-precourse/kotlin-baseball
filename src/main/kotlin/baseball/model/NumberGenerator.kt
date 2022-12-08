package baseball.model

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {

    fun createBaseballNumbers(): List<Int> {
        val baseballNumbers = mutableListOf<Int>()
        while (baseballNumbers.size < BASEBALL_NUMBERS_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(BASEBALL_NUMBERS_MIN_NUMBER, BASEBALL_NUMBERS_MAX_NUMBER)
            if (!baseballNumbers.contains(randomNumber)) {
                baseballNumbers.add(randomNumber)
            }
        }
        return baseballNumbers
    }

    companion object {
        const val BASEBALL_NUMBERS_SIZE = 3
        const val BASEBALL_NUMBERS_MIN_NUMBER = 1
        const val BASEBALL_NUMBERS_MAX_NUMBER = 9
    }

}