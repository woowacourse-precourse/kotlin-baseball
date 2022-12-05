package baseball

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class JudgmentTest {
    private val inputNumbers = listOf<Int>(1, 2, 3)
    private lateinit var judgment: Judgment

    @BeforeEach
    fun setup() {
        judgment = Judgment()
    }

    @ParameterizedTest
    @CsvSource(
        "1,2,3,3스트라이크",
        "1,2,5,2스트라이크",
        "6,9,5,''"
    )
    fun `스트라이크 테스트`(number1: Int, number2: Int, number3: Int, expectedResult: String) {
        val countStrikeResult = judgment.countStrike(inputNumbers, listOf<Int>(number1, number2, number3))
        Assertions.assertThat(countStrikeResult).isEqualTo(expectedResult)
    }

    @ParameterizedTest
    @CsvSource(
        "3,1,2,3볼",
        "1,3,2,2볼",
        "1,2,3,''"
    )
    fun `볼 테스트`(number1: Int, number2: Int, number3: Int, expectedResult: String) {
        val countBallResult = judgment.countBall(inputNumbers, listOf<Int>(number1, number2, number3))
        Assertions.assertThat(countBallResult).isEqualTo(expectedResult)
    }

}