package baseball

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MyTest {
    @Test
    fun `각각 다른 숫자인지 확인`() {
        val input = "345"
        Assertions.assertThat(checkSameNumber(input)).isEqualTo(false)
    }

    @Test
    fun `같은 숫자가 있는지 확인`() {
        val input = "334"
        Assertions.assertThat(checkSameNumber(input)).isEqualTo(true)
    }

    @Test
    fun `같은 숫자를 입력했을 때 예외처리`() {
        val assertThrows = assertThrows<IllegalArgumentException> {
            exceptionHandling("223")
        }
        org.junit.jupiter.api.Assertions.assertEquals(assertThrows.message, null)
    }

    @Test
    fun `세자리의 수를 입력하지 않았을 때 예외처리`() {
        val assertThrows = assertThrows<IllegalArgumentException> {
            exceptionHandling("2")
        }
        org.junit.jupiter.api.Assertions.assertEquals(assertThrows.message, null)
    }

    @Test
    fun `한글을 입력했을 때 예외처리`() {
        val assertThrows = assertThrows<IllegalArgumentException> {
            exceptionHandling("가나다")
        }
        org.junit.jupiter.api.Assertions.assertEquals(assertThrows.message, null)
    }

    @Test
    fun `영어를 입력했을 때 예외처리`() {
        val assertThrows = assertThrows<IllegalArgumentException> {
            exceptionHandling("abc")
        }
        org.junit.jupiter.api.Assertions.assertEquals(assertThrows.message, null)
    }

    @Test
    fun `볼과 스트라이크 모두 합한 수`() {
        val result = countTotal(mutableListOf(2, 1, 3), mutableListOf(1, 2, 3))
        Assertions.assertThat(result).isEqualTo(3)
    }

    @Test
    fun `스트라이크인 경우의 수만 반환`() {
        val result = countStrike(mutableListOf(2, 1, 3), mutableListOf(1, 2, 3))
        Assertions.assertThat(result).isEqualTo(1)
    }

    @Test
    fun `2볼 1스트라이크 반환`() {
        val result = determineResult(mutableListOf(2, 1, 3), mutableListOf(1, 2, 3))
        Assertions.assertThat(result).isEqualTo("2볼 1스트라이크")
    }
}