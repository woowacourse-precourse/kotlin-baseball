package utils

import camp.nextstep.edu.missionutils.Randoms
import computer.ComputerNumbers

object RandomGenerator {
    fun create(): ComputerNumbers {
        val computers = linkedSetOf<Int>()
        while (computers.size < 3) {
            val randomNumber = Randoms.pickNumberInRange(1, 9)
            computers.add(randomNumber)
        }
        return ComputerNumbers(computers.toList())
    }
}