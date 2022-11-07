package baseball

import camp.nextstep.edu.missionutils.Randoms

object RandomNumberGenerator {
    fun nDigitMap(digitNumber: Int): Map<Int, Int> {
        val nDigitMap = hashMapOf<Int, Int>()
        for (i in 0 until digitNumber) {
            nDigitMap[generateNotDuplicatedNumber(nDigitMap)] = i
        }
        return nDigitMap
    }

    fun generateNotDuplicatedNumber(computerNumbers: Map<Int, Int>): Int {
        var randomNumber = Randoms.pickNumberInRange(1, 9)
        while (computerNumbers.containsKey(randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(1, 9)
        }
        return randomNumber
    }
}