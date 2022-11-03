package baseball.computer

import baseball.common.MAX_NUMBER_SIZE
import baseball.common.MAX_OF_NUMBER
import baseball.common.MIN_OF_NUMBER
import camp.nextstep.edu.missionutils.Randoms

class Computer {
    private val numberOfComputer = hashSetOf<Int>()

    init {
        createRandomNumber()
    }

    private fun createRandomNumber() {
        do {
            val randomNumber = Randoms.pickNumberInRange(MIN_OF_NUMBER, MAX_OF_NUMBER)

            numberOfComputer.add(randomNumber)
        } while (numberOfComputer.size < MAX_NUMBER_SIZE)
    }
}