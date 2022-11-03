package utils

import camp.nextstep.edu.missionutils.Randoms
import domain.Computer

object RandomGenerator {
    fun create(): Computer {
        val computers = linkedSetOf<Int>()
        while (computers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            computers.add(randomNumber)
        }
        return Computer(computers.toList())
    }
}