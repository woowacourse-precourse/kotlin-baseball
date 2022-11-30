package baseball.model

import baseball.util.MAX_NUMBER
import baseball.util.MAX_SIZE
import baseball.util.MIN_NUMBER
import camp.nextstep.edu.missionutils.Randoms

class Computer {

    fun createComputerNumber(): String {
        val computer = mutableListOf<Int>()
        while (computer.size < MAX_SIZE) {
            val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer.joinToString("")
    }
}
