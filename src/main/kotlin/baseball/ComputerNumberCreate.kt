package baseball

import baseball.Constant.Companion.maxRangeNum
import baseball.Constant.Companion.minRangeNum
import baseball.Constant.Companion.numRange
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class ComputerNumberCreate() {
    val computerNumber = makeNum()

    private fun randomNum() = pickNumberInRange(minRangeNum, maxRangeNum)

    private fun appendNum(randomNum:Int, numList:MutableList<Int>){
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