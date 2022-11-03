package baseball

import baseball.Constant.Companion.maxRangeNumber
import baseball.Constant.Companion.minRangeNumber
import baseball.Constant.Companion.numRange
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class ComputerNumberCreate() {
    val computerNumber = makeNum()

    private fun randomNum() = pickNumberInRange(minRangeNumber, maxRangeNumber)

    private fun appendNum(randomNum: Int, numList: MutableList<Int>) {
        if (!numList.contains(randomNum)) {
            numList.add(randomNum)
        }
    }

    private fun makeNum(): MutableList<Int> {
        val makeThreeNum = mutableListOf<Int>()
        while (makeThreeNum.size < numRange) {
            appendNum(randomNum(), makeThreeNum)
        }
        return makeThreeNum
    }
}