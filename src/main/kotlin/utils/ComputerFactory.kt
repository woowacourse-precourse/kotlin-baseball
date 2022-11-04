package utils

import camp.nextstep.edu.missionutils.Randoms
import domain.Computer
import utils.Constants.DIGIT_LENGTH
import utils.Constants.MAX_DIGIT
import utils.Constants.MIN_DIGIT

object ComputerFactory {
    fun create(): Computer {
        val computers = linkedSetOf<Int>()
        while (computers.size < DIGIT_LENGTH) {
            val randomNumber = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT)
            computers.add(randomNumber)
        }
        return Computer(computers.toList())
    }
}