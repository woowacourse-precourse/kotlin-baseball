package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ApplicationTest : NsTest() {
    @Test
    fun `게임종료 후 재시작`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "135", "1", "597", "589", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    override fun runMain() {
        main()
    }

    private lateinit var outputStreamCaptor: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        this.outputStreamCaptor = ByteArrayOutputStream()
    }

    @DisplayName("3자리 인지 검사")
    @Test
    fun `checkThreeNumberTest`() {
        val input = "12"
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { checkThreeNumber(input)}
        }
    }

    @DisplayName("서로 다른 3자리수 인지 검사")
    @Test
    fun `checkSameNumberTest`() {
        val input = "112"
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { checkSameNumber(input)}
        }
    }

    @DisplayName("//입력된 값이 1~9가 아닐떄 테스트")
    @Test
    fun `checkNumberTest`() {
        val input = "qwe"
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { checkNumber(input)}
        }
    }

    @DisplayName("낫싱")
    @Test
    fun `isContainNumberTest`() {
        System.setOut(PrintStream(outputStreamCaptor))

        isContainNumber("123","456")

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("낫싱")
    }

    @DisplayName("1스트라이크")
    @Test
    fun `1스트라이크 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        isContainNumber("958","947")
        printHint()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1스트라이크")
    }

    @DisplayName("2스트라이크")
    @Test
    fun `2스트라이크 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        isContainNumber("948","947")
        printHint()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("2스트라이크")
    }

    @DisplayName("1볼")
    @Test
    fun `1볼 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        isContainNumber("756","947")
        printHint()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1볼")
    }

    @DisplayName("2볼")
    @Test
    fun `2볼 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        isContainNumber("796","947")
        printHint()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("2볼")
    }

    @DisplayName("3볼")
    @Test
    fun `3볼 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        isContainNumber("794","947")
        printHint()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("3볼")
    }

    @DisplayName("1볼 1스트라이크")
    @Test
    fun `1볼 1스트라이크 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        isContainNumber("746","947")
        printHint()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1볼 1스트라이크")
    }

    @DisplayName("2볼 1스트라이크")
    @Test
    fun `2볼 1스트라이크 힌트 출력 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        isContainNumber("749","947")
        printHint()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("2볼 1스트라이크")
    }

    @DisplayName("게임 종료")
    @Test
    fun `정답 이후 게임 종료 테스트`() {
        System.setOut(PrintStream(outputStreamCaptor))

        isContainNumber("947","947")
        System.setIn(ByteArrayInputStream("2".toByteArray()))
        endGame()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("게임 종료")
    }
}
