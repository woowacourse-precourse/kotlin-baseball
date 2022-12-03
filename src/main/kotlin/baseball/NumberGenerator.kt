package baseball

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {

    fun createBaseballNumbers(): List<Int> {
        val baseballNumbers = mutableListOf<Int>()
        while (baseballNumbers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            if (!baseballNumbers.contains(randomNumber)) {
                baseballNumbers.add(randomNumber)
            }
        }
        return baseballNumbers
    }


}