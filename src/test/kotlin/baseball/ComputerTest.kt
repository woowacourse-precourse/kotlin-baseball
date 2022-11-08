package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

private const val NOTHING_MESSAGE = "낫싱"
private const val BALL_MESSAGE = "볼"
private const val STRIKE_MESSAGE = "스트라이크"
private val output = ByteArrayOutputStream()

class ComputerTest {
    @BeforeEach
    fun setUpOutputStream() {
        System.setOut(PrintStream(output))
    }

    @AfterEach
    fun resetOutputStream() {
        System.setOut(System.out)
        output.reset()
    }

    @Test
    fun `랜덤 생성 숫자 자리수 확인`() {
        assertThat(answer.size).isEqualTo(3)
    }

    @Test
    fun `서로 다른 숫자 3개인지 확인`() {
        assertThat(answer.distinct().size).isEqualTo(3)
    }

    @Test
    fun `스트라이크 확인`() {
        computer.testSetAnswer(arrayListOf(1, 2, 3))
        computer.compareGuessAndAnswer(listOf(1, 5, 6))
        assertThat(output.toString().trim()).isEqualTo("1$STRIKE_MESSAGE")
    }

    @Test
    fun `볼 확인`() {
        computer.testSetAnswer(arrayListOf(1, 2, 3))
        computer.compareGuessAndAnswer(listOf(2, 1, 5))
        assertThat(output.toString().trim()).isEqualTo("2$BALL_MESSAGE")
    }

    @Test
    fun `볼 스트라이크 확인`() {
        computer.testSetAnswer(arrayListOf(1, 2, 3))
        computer.compareGuessAndAnswer(listOf(1, 3, 2))
        assertThat(output.toString().trim()).isEqualTo("2$BALL_MESSAGE 1$STRIKE_MESSAGE")
    }

    @Test
    fun `낫싱 확인`() {
        computer.testSetAnswer(arrayListOf(1, 2, 3))
        computer.compareGuessAndAnswer(listOf(6, 5, 4))
        assertThat(output.toString().trim()).isEqualTo(NOTHING_MESSAGE)
    }

    companion object {
        lateinit var computer: Computer
        lateinit var answer: ArrayList<Int>

        @BeforeAll
        @JvmStatic
        internal fun init() {
            computer = Computer()
            computer.generateAnswer()
            answer = computer.testGetAnswer()
        }
    }
}