package baseball

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayInputStream

internal class `Input 파일의` {

    @Nested
    inner class `readAnswer 메소드는` : NsTest() {

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `사용자가 콘솔에 입력한 숫자가 3자리가 아니면` {
            private fun inputs() = listOf(
                Arguments.of("1"),
                Arguments.of("1234")
            )

            @ParameterizedTest
            @MethodSource("inputs")
            fun `IllegalArgumentException 예외를 던진다`(input: String) {
                assertThatThrownBy { run(input) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        @Nested
        inner class `사용자가 콘솔에 입력한 값에 0이나 숫자가 아닌 값이 포함되었다면` {
            private fun inputs() = listOf(
                Arguments.of("120"),
                Arguments.of("12a")
            )

            @ParameterizedTest
            @MethodSource("inputs")
            fun `IllegalArgumentException 예외를 던진다`(input: String) {
                assertThatThrownBy { run(input) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `사용자가 콘솔에 입력한 숫자가 모두 다르지 않다면` {
            private val input = "122"

            @Test
            fun `IllegalArgumentException 예외를 던진다`() {
                assertThatThrownBy { run(input) }.isInstanceOf(IllegalArgumentException::class.java)
            }
        }

        @Nested
        inner class `사용자가 콘솔에 0을 제외한 서로 다른 3개의 숫자를 입력하면` {
            private val input = "123"

            @Test
            fun `입력한 값을 반환한다`() {
                System.setIn(ByteArrayInputStream(input.toByteArray()))
                val answer = readAnswer()

                assertThat(answer).isEqualTo(input)
            }
        }

        override fun runMain() {
            readAnswer()
        }
    }
}