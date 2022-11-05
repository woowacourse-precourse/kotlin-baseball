package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.function.Executable
import org.mockito.ArgumentMatchers
import org.mockito.MockedStatic.Verification

fun main() {
    val computer = getComputerRandomNumber()
    println("숫자 야구 게임을 시작합니다.")
    while (true) {
        println("숫자를 입력해주세요 : ")
        val player = Console.readLine()
        if (!isCorrectNumber(player)) {
            throw IllegalArgumentException()
        }
    }
}

fun getComputerRandomNumber(): List<Int> {
    val computer = mutableListOf<Int>()
    while (computer.size < 3) {
        val randomNumber = pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber))
            computer.add(randomNumber)
    }
    return computer
}

fun isCorrectNumber(player: String): Boolean {
    // 1. 3자리 수가 아닐 경우 false
    if (player.length != 3)
        return false
    // 2. 1-9의 범위를 벗어난 숫자가 아닐 경우 false
    for (c in player) {
        if (c < '1' || c > '9')
            return false
    }

    return true
}