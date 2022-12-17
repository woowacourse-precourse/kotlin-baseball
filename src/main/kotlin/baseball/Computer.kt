package baseball

import camp.nextstep.edu.missionutils.Randoms

private const val BASEBALL_SIZE = 3
private const val NUMBER_RANGE_START = 1
private const val NUMBER_RANGE_END = 9

class Computer() {
    private val _computerNumbers = mutableListOf<Int>()
    val computerNumbers: List<Int> get() = _computerNumbers

    fun createNumbers() {
        _computerNumbers.clear()
        while (_computerNumbers.size < BASEBALL_SIZE) {
            val randomNumber: Int = createNumberInRange()
            if (isNumberRepeated(randomNumber)) {
                _computerNumbers.add(randomNumber)
            }
        }
    }

    private fun createNumberInRange(): Int {
        return Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END)
    }

    private fun isNumberRepeated(randomNumber: Int): Boolean {
        return (!_computerNumbers.contains(randomNumber))
    }
}
