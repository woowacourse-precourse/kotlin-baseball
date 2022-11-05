package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream
import java.lang.IllegalArgumentException

class FunctionTest {
    @Test
    fun `잘못된 자리수 입력`() {
        assertThrows<IllegalArgumentException>() {
            val input = "1";
            System.setIn(input.byteInputStream());
            getUserInput(false)
        }
        assertThrows<IllegalArgumentException>() {
            val input = "1234";
            System.setIn(input.byteInputStream());
            getUserInput(false)
        }
    }

    @Test
    fun `잘못된 문자 입력`() {
        assertThrows<IllegalArgumentException>() {
            val input = "12a";
            System.setIn(input.byteInputStream());
            getUserInput(false)
        }
    }

    @Test
    fun `유저 입력 반환`() {
        val input = "123";
        System.setIn(input.byteInputStream());
        val result = getUserInput(false)
        assertThat(result).contains("123")
    }

    @Test
    fun `게임 재시작 입력`() {
        val input = "1";
        System.setIn(input.byteInputStream());
        val result = getUserInput(true)
        assertThat(result).contains("1")
    }
}