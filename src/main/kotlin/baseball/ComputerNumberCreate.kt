package baseball

import baseball.Constant.Companion.maxRangeNumber
import baseball.Constant.Companion.minRangeNumber
import baseball.Constant.Companion.numberRange
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class ComputerNumberCreate() {
    val computerNumber = makeNumber()

    private fun randomNumber() = pickNumberInRange(minRangeNumber, maxRangeNumber) // 1 ~ 9 랜덤 숫자 생성

    private fun appendNumber(randomNumber: Int, numberList: MutableList<Int>) {
        if (!numberList.contains(randomNumber)) { // 중복된 숫자가 아니면 add
            numberList.add(randomNumber)
        }
    }

    private fun makeNumber(): MutableList<Int> {
        val computerNumber = mutableListOf<Int>()
        while (computerNumber.size < numberRange) {
            appendNumber(randomNumber(), computerNumber)
        }
        return computerNumber
    }
}