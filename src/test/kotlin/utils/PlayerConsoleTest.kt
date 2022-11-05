package utils

import org.junit.jupiter.api.*
import utils.Constants.DUPLICATED_DIGIT_EXCEPTION
import utils.Constants.LENGTH_MISMATCH_EXCEPTION
import utils.Constants.NON_DIGIT_EXCEPTION
import utils.Constants.OUT_OF_RANGE_EXCEPTION

import utils.PlayerConsole.enterAnswer
import java.io.ByteArrayInputStream

internal class PlayerConsoleTest {
    @Nested
    inner class InputLengthTest {
        @DisplayName("입력값 길이 1")
        @Test
        fun `입력값 길이가 1인 경우 예외 발생`() {
            assertThrows<IllegalArgumentException>(LENGTH_MISMATCH_EXCEPTION) {
                System.setIn(ByteArrayInputStream("1".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값 길이 2")
        @Test
        fun `입력값 길이가 2인 경우 예외 발생`() {
            assertThrows<IllegalArgumentException>(LENGTH_MISMATCH_EXCEPTION) {
                System.setIn(ByteArrayInputStream("17".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값 길이 3")
        @Test
        fun `입력값 길이가 3인 경우 예외 발생 하지 않음`() {
            assertDoesNotThrow {
                System.setIn(ByteArrayInputStream("123".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값 길이 4")
        @Test
        fun `입력값 길이가 4인 경우 예외 발생`() {
            assertThrows<IllegalArgumentException>(LENGTH_MISMATCH_EXCEPTION) {
                System.setIn(ByteArrayInputStream("1999".toByteArray()))
                enterAnswer()
            }
        }
    }

    @Nested
    inner class DuplicatedTest {
        @DisplayName("입력값 중복 없음")
        @Test
        fun `입력값에 중복이 없는 경우 예외 발생 하지 않음`() {
            assertDoesNotThrow {
                System.setIn(ByteArrayInputStream("123".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값 2개 중복")
        @Test
        fun `입력값에 중복이 2개 있을 경우 예외 발생`() {
            assertThrows<IllegalArgumentException>(DUPLICATED_DIGIT_EXCEPTION) {
                System.setIn(ByteArrayInputStream("177".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값 3개 중복")
        @Test
        fun `입력값에 중복이 3개 있을 경우 예외 발생`() {
            assertThrows<IllegalArgumentException>(DUPLICATED_DIGIT_EXCEPTION) {
                System.setIn(ByteArrayInputStream("777".toByteArray()))
                enterAnswer()
            }
        }
    }

    @Nested
    inner class DigitCheckTest {
        @DisplayName("입력값에 숫자만 포함")
        @Test
        fun `입력값에 숫자만 포함한 경우 예외 발생 하지 않음`() {
            assertDoesNotThrow {
                System.setIn(ByteArrayInputStream("123".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값에 알파벳 포함")
        @Test
        fun `입력값에 알파벳 포함한 경우 예외 발생`() {
            assertThrows<IllegalArgumentException>(NON_DIGIT_EXCEPTION) {
                System.setIn(ByteArrayInputStream("a12".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값에 특수문자 포함")
        @Test
        fun `입력값에 특수문자 포함`() {
            assertThrows<IllegalArgumentException>(NON_DIGIT_EXCEPTION) {
                System.setIn(ByteArrayInputStream("!12".toByteArray()))
                enterAnswer()
            }
        }
    }

    @Nested
    inner class RangeTest {
        @DisplayName("범위가 1 to 9")
        @Test
        fun `입력값의 범위가 초과하지 않은 경우`() {
            assertDoesNotThrow {
                System.setIn(ByteArrayInputStream("123".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("범위가 1보다 작은 경우")
        @Test
        fun `입력값이 1보다 작은 경우`() {
            assertThrows<IllegalArgumentException>(OUT_OF_RANGE_EXCEPTION) {
                System.setIn(ByteArrayInputStream("102".toByteArray()))
                enterAnswer()
            }
        }
    }
}