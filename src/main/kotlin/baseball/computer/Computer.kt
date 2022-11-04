package baseball.computer

import baseball.common.MAX_NUMBER_SIZE
import baseball.common.MAX_OF_NUMBER
import baseball.common.MIN_OF_NUMBER
import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private val _numberOfComputer = hashSetOf<Int>()
    val numberOfComputer: String
        get() = _numberOfComputer.joinToString("")

    init {
        createRandomNumber()
    }

    private fun createRandomNumber() {
        do {
            val randomNumber = Randoms.pickNumberInRange(MIN_OF_NUMBER, MAX_OF_NUMBER)

            _numberOfComputer.add(randomNumber)
        } while (_numberOfComputer.size < MAX_NUMBER_SIZE)
    }
}