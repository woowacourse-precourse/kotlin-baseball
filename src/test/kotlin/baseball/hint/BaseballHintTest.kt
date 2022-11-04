package baseball.hint

import domain.Computer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import utils.PlayerConsole
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class BaseballHintTest {

    private lateinit var outputStreamCaptor: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        this.outputStreamCaptor = ByteArrayOutputStream()
    }

    @DisplayName("3스트라이크")
    @Test
    fun `컴퓨터와 플레이어 정답 상황의 힌트 출력 예시`() {
        System.setIn(ByteArrayInputStream("123".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 2, 3))
        val player = PlayerConsole.enterAnswer()

        val baseballHint: Hint = BaseballHint(computer, player)
        baseballHint.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("3스트라이크")
    }

    @DisplayName("2볼 1스트라이크")
    @Test
    fun `컴퓨터와 플레이어 2볼 1스트라이크 힌트 출력 예시`() {
        System.setIn(ByteArrayInputStream("123".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 3, 2))
        val player = PlayerConsole.enterAnswer()

        val baseballHint: Hint = BaseballHint(computer, player)
        baseballHint.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("2볼 1스트라이크")
    }

    @DisplayName("1볼 1스트라이크")
    @Test
    fun `컴퓨터와 플레이어 1볼 1스트라이크 힌트 출력 예시`() {
        System.setIn(ByteArrayInputStream("143".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 3, 2))
        val player = PlayerConsole.enterAnswer()

        val baseballHint: Hint = BaseballHint(computer, player)
        baseballHint.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1볼 1스트라이크")
    }

    @DisplayName("1스트라이크")
    @Test
    fun `컴퓨터와 플레이어 1스트라이크 힌트 출력 예시`() {
        System.setIn(ByteArrayInputStream("145".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 3, 2))
        val player = PlayerConsole.enterAnswer()

        val baseballHint: Hint = BaseballHint(computer, player)
        baseballHint.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1스트라이크")
    }

    @DisplayName("1볼")
    @Test
    fun `컴퓨터와 플레이어 1볼 힌트 출력 예시`() {
        System.setIn(ByteArrayInputStream("981".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 3, 2))
        val player = PlayerConsole.enterAnswer()

        val baseballHint: Hint = BaseballHint(computer, player)
        baseballHint.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1볼")
    }

    @DisplayName("2볼")
    @Test
    fun `컴퓨터와 플레이어 2볼 힌트 출력 예시`() {
        System.setIn(ByteArrayInputStream("923".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 3, 2))
        val player = PlayerConsole.enterAnswer()

        val baseballHint: Hint = BaseballHint(computer, player)
        baseballHint.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("2볼")
    }

    @DisplayName("3볼")
    @Test
    fun `컴퓨터와 플레이어 3볼 힌트 출력 예시`() {
        System.setIn(ByteArrayInputStream("213".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 3, 2))
        val player = PlayerConsole.enterAnswer()

        val baseballHint: Hint = BaseballHint(computer, player)
        baseballHint.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("3볼")
    }

}