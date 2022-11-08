package baseball

import camp.nextstep.edu.missionutils.Randoms

class Computer() {
    private val _computerNumbers = mutableListOf<Int>()
    val computerNumbers: List<Int> get() = _computerNumbers

    fun createNumbers() {
        _computerNumbers.clear()
        while (_computerNumbers.size < 3) {
            val randomNumber: Int = createNumberInRange()
            if (isNumberRepeated(randomNumber)) {
                _computerNumbers.add(randomNumber)
            }
        }
    }

    private fun createNumberInRange(): Int {
        return Randoms.pickNumberInRange(1, 9)
    }

    private fun isNumberRepeated(randomNumber: Int): Boolean {
        return (!_computerNumbers.contains(randomNumber))
    }
}
