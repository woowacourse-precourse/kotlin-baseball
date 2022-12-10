package baseball

import baseball.view.io.OutputView
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

class OutputViewTest {
    private lateinit var outputView: OutputView
    private val outputStream: OutputStream = ByteArrayOutputStream()

    @BeforeEach
    fun `setup`() {
        outputView = OutputView()
        System.setOut(PrintStream(outputStream))
    }

    @ParameterizedTest
    @CsvSource(
        "true,3개의 숫자를 모두 맞히셨습니다! 게임 종료",
        "false,''"
    )
    fun `게임을 승리할시 안내문을 출력하는지 테스트`(isWinGame: Boolean, expectValue: String) {
        outputView.winGame(isWinGame)
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(expectValue)
    }

    @ParameterizedTest
    @CsvSource(
        "TDD방법론은,TDD방법론은",
        "오히려,오히려" ,
        "프로젝트 개발 경험이 적을수록 유용한거 같다,프로젝트 개발 경험이 적을수록 유용한거 같다"
    )
    fun `판정의 결과를 출력하는 기능 테스트`(outputText: String, expectValue: String) {
        outputView.judgementResult(outputText)
        Assertions.assertThat(outputStream.toString().trim()).isEqualTo(expectValue)
    }

}