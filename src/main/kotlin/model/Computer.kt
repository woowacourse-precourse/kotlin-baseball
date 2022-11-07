package model

import camp.nextstep.edu.missionutils.Randoms

import util.Constants.MAX_SIZE
import util.Constants.RANGE_END
import util.Constants.RANGE_START

class Computer {
    private val _randomNumberList = mutableListOf<Int>()
    val randomNumberList: List<Int>
        get() = _randomNumberList

    // 랜덤한 범위의 숫자 3개를 중복없이 생성한다
    fun registerNumbersToList() {
        _randomNumberList.clear()
        _randomNumberList.apply {
            while (!isFull(this)) {
                addRandomNumber(this, Randoms.pickNumberInRange(RANGE_START, RANGE_END))
            }
        }
    }

    private fun addRandomNumber(list: MutableList<Int>, number: Int) {
        if (!list.contains(number)) {
            list.add(number)
        }
    }

    private fun isFull(list: MutableList<Int>) = list.size == MAX_SIZE
}