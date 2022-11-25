package baseball

import camp.nextstep.edu.missionutils.Randoms

class RandomInput {

    fun getRandomNumberList(): List<Int> {
        val randomList = mutableListOf<Int>()
        while (randomList.size < INPUT_LENGTH_STANDARD) {
            val newRandomNum = getEachRandomNumber()
            if (!Regex().checkNumberIsContained("Rand", newRandomNum, randomList)) {
                randomList.add(newRandomNum)
            }
        }
        return randomList
    }

    private fun getEachRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
    }
}