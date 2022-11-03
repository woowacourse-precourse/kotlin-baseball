package utils

import org.junit.jupiter.api.*

import utils.InputUtil.enterAnswer
import java.io.ByteArrayInputStream

internal class InputUtilTest {
    @Nested
    inner class InputLengthTest {
        @DisplayName("입력값 길이 1")
        @Test
        fun `입력값 길이가 1인 경우 예외 발생`() {
            assertThrows<IllegalArgumentException>("입력값의 길이가 3이 아닙니다.") {
                System.setIn(ByteArrayInputStream("1".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값 길이 2")
        @Test
        fun `입력값 길이가 2인 경우 예외 발생`() {
            assertThrows<IllegalArgumentException>("입력값의 길이가 3이 아닙니다.") {
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
            assertThrows<IllegalArgumentException>("입력값의 길이가 3이 아닙니다.") {
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
            assertThrows<IllegalArgumentException>("중복된 숫자가 존재합니다.") {
                System.setIn(ByteArrayInputStream("177".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값 3개 중복")
        @Test
        fun `입력값에 중복이 3개 있을 경우 예외 발생`() {
            assertThrows<IllegalArgumentException>("중복된 숫자가 존재합니다.") {
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
            assertThrows<IllegalArgumentException>("입력값이 숫자가 아닙니다.") {
                System.setIn(ByteArrayInputStream("a12".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값에 특수문자 포함")
        @Test
        fun `입력값에 특수문자 포함`() {
            assertThrows<IllegalArgumentException>("입력값이 숫자가 아닙니다.") {
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
            assertThrows<IllegalArgumentException>("입력값이 올바른 범위가 아닙니다.") {
                System.setIn(ByteArrayInputStream("102".toByteArray()))
                enterAnswer()
            }
        }
    }
}