package baseball

import baseball.Constant.Companion.maxRangeNumber
import baseball.Constant.Companion.minRangeNumber
import baseball.Constant.Companion.numberRange
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class ComputerNumberCreate() {
    val computerNumber = makeNum()

    private fun randomNum() = pickNumberInRange(minRangeNumber, maxRangeNumber) // 1 ~ 9 랜덤 숫자 생성

    private fun appendNum(randomNum: Int, numList: MutableList<Int>) {
        if (!numList.contains(randomNum)) { // 중복된 숫자가 아니면 add
            numList.add(randomNum)
        }
    }

    private fun makeNum(): MutableList<Int> {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size < numberRange) {
            appendNum(randomNum(), computerNumber)
        }
        return computerNumber
    }
}