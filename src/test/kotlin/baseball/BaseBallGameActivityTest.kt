package baseball

import baseball.controller.BaseballActivity
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

class BaseBallGameActivityTest {
    private lateinit var baseballActivity: BaseballActivity
    private val inputNumbers = listOf<Int>(1, 2, 3)
    private val outputStream: OutputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setup() {
        baseballActivity = BaseballActivity()
        System.setOut(PrintStream(outputStream))
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
    fun `숫자 야구 게임 판정 결과 테스트`(number1: Int, number2: Int, number3: Int, testResult: String) {
        val judgementResult = baseballActivity.getJudgementResult(inputNumbers, listOf<Int>(number1, number2, number3))
        Assertions.assertThat(judgementResult).isEqualTo(testResult)
    }


}