package baseball

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ComputerNumbersTest {
    private lateinit var computerNumbers: ComputerNumbers

    @BeforeEach
    fun `computerNumbers 초기화`() {
        computerNumbers = ComputerNumbers(mapOf(1 to 0, 3 to 1, 5 to 2))
    }

    @Test
    fun `countStrikeAndBall 메서드로 한 자리 숫자의 strike, ball 결과를 반환`() {
        val inputList = listOf(2 to 0, 1 to 1, 3 to 1)
        val result = inputList.map { input ->
            computerNumbers.countStrikeAndBall(number = input.first, index = input.second)
        }
        assertThat(result)
            .contains(
                BaseballResult(0, 0),
                BaseballResult(1, 0),
                BaseballResult(0, 1)
            )
    }

    @Test
    fun `compareToUserInput 메서드로 세 자리 숫자의 strike, ball 결과를 반환`() {
        val inputList = listOf("246", "135", "154")
        val result = inputList.map { input ->
            computerNumbers.compareToUserInput(userInput = input)
        }
        assertThat(result)
            .contains(
                BaseballResult(0, 0),
                BaseballResult(0, 3),
                BaseballResult(1, 1)
            )
    }
}