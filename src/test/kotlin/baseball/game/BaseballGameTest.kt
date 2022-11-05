package baseball.game

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import utils.Constants
import utils.Constants.LENGTH_MISMATCH_EXCEPTION
import utils.Constants.WRONG_FORMAT_EXCEPTION
import utils.PlayerConsole
import java.io.ByteArrayInputStream

internal class BaseballGameTest {

    @DisplayName("재시작 입력값 : 1")
    @Test
    fun `재시작 입력값이 1인 경우`() {
        System.setIn(ByteArrayInputStream("1".toByteArray()))

        assertDoesNotThrow {
            val restart = PlayerConsole.enterRestart()
            assertEquals(restart, Constants.YES_RESTART)
        }
    }

    @DisplayName("재시작 입력값 : 2")
    @Test
    fun `재시작 입력값이 2인 경우`() {
        System.setIn(ByteArrayInputStream("2".toByteArray()))

        assertDoesNotThrow {
            val restart = PlayerConsole.enterRestart()
            assertEquals(restart, Constants.NO_RESTART)
        }
    }

    @DisplayName("재시작 입력값 : 3")
    @Test
    fun `재시작 입력값이 1과 2가 아닌 경우 예외 발생`() {
        assertThrows<IllegalArgumentException>(WRONG_FORMAT_EXCEPTION) {
            System.setIn(ByteArrayInputStream("3".toByteArray()))
            PlayerConsole.enterRestart()
        }
    }

    @DisplayName("재시작 입력값 : 123")
    @Test
    fun `재시작 입력값의 길이가 1을 초과한 경우 예외 발생`() {
        assertThrows<IllegalArgumentException>(LENGTH_MISMATCH_EXCEPTION) {
            System.setIn(ByteArrayInputStream("123".toByteArray()))
            PlayerConsole.enterRestart()
        }
    }
}