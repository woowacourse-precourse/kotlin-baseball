package baseball

import baseball.view.OutputView
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

class OutputViewTest {
    private lateinit var outputView: OutputView
    private val inputNumbers = listOf<Int>(1, 2, 3)
    private val outputStream: OutputStream = ByteArrayOutputStream()

    @BeforeEach
    fun setup() {
        outputView = OutputView()
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
    fun `숫자 야구 게임 판정 결과 테스트`(number1: Int, number2: Int, number3: Int, outputResult: String) {
        outputView.judgementResult(inputNumbers, listOf<Int>(number1, number2, number3))
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(outputResult)
    }

    @ParameterizedTest
    @CsvSource(
        "1,2,3,true",
        "1,2,4,false",
    )
    fun `스트라이크의 개수가 3인지 확인하는 기능 테스트`(number1: Int, number2: Int, number3: Int, testResult: Boolean) {
        val isThreeStrike = outputView.isThreeStrike(inputNumbers, listOf<Int>(number1, number2, number3))
        Assertions.assertThat(isThreeStrike).isEqualTo(testResult)

    }
}