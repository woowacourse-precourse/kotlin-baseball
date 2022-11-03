package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class StringTest {
    @Test
    //commit test
    fun `split 메서드로 주어진 값을 구분`() {
        val input = "1,2"
        val result = input.split(",")
        assertThat(result).contains("2", "1")
        assertThat(result).containsExactly("1", "2")
    }

    @Test
    fun `split 메서드 사용시 구분자가 포함되지 않은 경우 값을 그대로 반환`() {
        val input = "1"
        val result = input.split(",")
        assertThat(result).contains("1")
    }

    @Test
    fun `substring 메서드로 특정 구간 값을 반환`() {
        val input = "(1,2)"
        val result = input.substring(1, 4)
        assertThat(result).isEqualTo("1,2")
    }

    @Test
    fun `get 메서드로 특정 위치의 문자 찾기`() {
        val input = "abc"
        val getElement = input[0]
        assertThat(getElement).isEqualTo('a')
    }

    @Test
    fun `get 메서드 사용시 문자열의 길이보다 큰 숫자 위치의 문자를 찾을 때 예외 발생`() {
        val input = "abc"
        assertThrows<StringIndexOutOfBoundsException>("String index out of range: 5") {
            input[5]
        }
    }
}
