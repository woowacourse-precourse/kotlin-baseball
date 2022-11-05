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

    @Test
    fun `스트라이크 검출`() {
        val randomNumber = "135";
        val userNumber = "132";
        val result = compareNumber(randomNumber, userNumber, 0)
        assertThat(result).isEqualTo(Score.STRIKE)
    }

    @Test
    fun `볼 검출`() {
        val randomNumber = "246";
        val userNumber = "421";
        val result = compareNumber(randomNumber, userNumber, 1)
        assertThat(result).isEqualTo(Score.BALL)
    }

    @Test
    fun `낫싱 검출`() {
        val randomNumber = "135";
        val userNumber = "246";
        val result = compareNumber(randomNumber, userNumber, 0)
        assertThat(result).isEqualTo(Score.NOTHING)
    }

    @Test
    fun `점수 결정 1`() {
        val randomNumber = "641";
        val userNumber = "246";
        val result = determineScore(randomNumber, userNumber)
        assertThat(result).containsExactly(1, 1, 1)
    }

    @Test
    fun `점수 결정 2`() {
        val randomNumber = "531";
        val userNumber = "741";
        val result = determineScore(randomNumber, userNumber)
        assertThat(result).containsExactly(2, 1, 0)
    }

    @Test
    fun `컴퓨터가 생성한 수의 길이 검사`() {
        val randomNumber = generateRandomNumber()
        assertThat(randomNumber).hasSize(3)
    }

    @Test
    fun `컴퓨터가 생성한 수의 중복 검사`() {
        val randomNumber = generateRandomNumber()
        for (i in randomNumber.indices) {
            val testNumber = randomNumber.removeRange(i, i + 1)
            assertThat(testNumber).doesNotContain(randomNumber[i].toString())
        }
    }

    @Test
    fun `점수 문자열화 검사 1`() {
        val result = formatScore(listOf(0, 1, 1))
        assertThat(result).isEqualTo("1볼 1스트라이크")
    }

    @Test
    fun `점수 문자열화 검사 2`() {
        val result = formatScore(listOf(1, 0, 0))
        assertThat(result).isEqualTo("낫싱")
    }

    @Test
    fun `점수 문자열화 검사 3`() {
        val result = formatScore(listOf(0, 3, 0))
        assertThat(result).isEqualTo("3스트라이크")
    }

    @Test
    fun `게임 종료 검사 1`() {
        val input = "1";
        System.setIn(input.byteInputStream());
        val result = exitGame(3)
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `게임 종료 검사 2`() {
        val input = "2";
        System.setIn(input.byteInputStream());
        val result = exitGame(3)
        assertThat(result).isEqualTo(true)
    }
}