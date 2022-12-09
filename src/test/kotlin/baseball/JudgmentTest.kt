package baseball

import baseball.model.Judgment
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
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
    fun `스트라이크 테스트`(number1: Int, number2: Int, number3: Int, expectValue: String) {
        val countStrikeResult = judgment.getStrikeResult(inputNumbers, listOf<Int>(number1, number2, number3))
        Assertions.assertThat(countStrikeResult).isEqualTo(expectValue)
    }

    @ParameterizedTest
    @CsvSource(
        "3,1,2,3볼",
        "1,3,2,2볼",
        "1,2,3,''"
    )
    fun `볼 테스트`(number1: Int, number2: Int, number3: Int, expectValue: String) {
        val countBallResult = judgment.getBallResult(inputNumbers, listOf<Int>(number1, number2, number3))
        Assertions.assertThat(countBallResult).isEqualTo(expectValue)
    }

    @ParameterizedTest
    @CsvSource(
        "3,1,2,false",
        "1,3,2,false",
        "1,2,3,true"
    )
    fun `3스트라이크 인지 테스트`(number1: Int, number2: Int, number3: Int, expectValue: Boolean) {
        val isThreeStrike = judgment.isThreeStrike(inputNumbers, listOf<Int>(number1, number2, number3))
        Assertions.assertThat(isThreeStrike).isEqualTo(expectValue)
    }

    @ParameterizedTest
    @CsvSource(
        "1,2,3,3스트라이크",
        "1,6,5,1스트라이크",
        "3,1,2,3볼",
        "3,7,9,1볼",
        "1,3,4,1볼 1스트라이크",
        "6,9,5,낫싱"
    )
    fun `판정 결과 테스트`(number1: Int, number2: Int, number3: Int, expectValue: String) {
        val judgementResult = judgment.getTotalResult(inputNumbers, listOf<Int>(number1, number2, number3))
        Assertions.assertThat(judgementResult).isEqualTo(expectValue)
    }

}