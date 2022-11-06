package baseball

import camp.nextstep.edu.missionutils.Randoms

object RandomNumberGenerator {

    fun nDigitList(digitNumber: Int): List<Int> {
        val nDigitList = mutableListOf<Int>()
        for (i in 0 until digitNumber) {
            nDigitList.add(generateNotDuplicatedNumber(nDigitList))
        }
        return nDigitList
    }

    fun nDigitMap(digitNumber: Int): Map<Int, Int> {
        val nDigitMap = hashMapOf<Int, Int>()
        for (i in 0 until digitNumber) {
            nDigitMap[generateNotDuplicatedNumber(nDigitMap)] = i
        }
        return nDigitMap
    }

    private fun generateNotDuplicatedNumber(computerNumbers: List<Int>): Int {
        var randomNumber = Randoms.pickNumberInRange(1, 9)
        while (computerNumbers.contains(randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(1, 9)
        }
        return randomNumber
    }

    private fun generateNotDuplicatedNumber(computerNumbers: Map<Int, Int>): Int {
        var randomNumber = Randoms.pickNumberInRange(1, 9)
        while (computerNumbers.containsKey(randomNumber)) {
            randomNumber = Randoms.pickNumberInRange(1, 9)
        }
        return randomNumber
    }
}