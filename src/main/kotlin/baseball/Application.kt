package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.function.Executable
import org.mockito.ArgumentMatchers
import org.mockito.MockedStatic.Verification

fun main() {
    val computer = getComputerRandomNumber()

}

fun getComputerRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = pickNumberInRange(1, 9)
        if(!computer.contains(randomNumber))
            computer.add(randomNumber)
    }
    return computer
}
