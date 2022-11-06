package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CorrectAnswerTest {
    @Test
    fun `모두 스트라이크일 때 스트라이크 3개 반환`() {
        assertCheck("123", "123", 3, 0)
    }

    @Test
    fun `모두 볼일 때 볼 3개 반환`() {
        assertCheck("123", "312", 0, 3)
    }

    @Test
    fun `모두 오답일 때 낫싱을 반환`() {
        assertCheck("123", "456", 0, 0)

    }

    @Test
    fun `사용자가 잘못된 값을 입력했을 때 IllegalArgumentException 반환`() {
        assertThrows<IllegalArgumentException>("잘못된 값을 입력했습니다.") {
            BaseballGame("123")
                .checkException("1234")
        }
    }

    @Test
    fun `오답 2개, 볼 1개일 때 볼 1개 반환`() {
        assertCheck("123", "782", 0, 1)
    }

    @Test
    fun `오답 2개, 스트라이크 1개일 때 스트라이크 1개 반환`() {
        assertCheck("123", "783", 1, 0)
    }

    @Test
    fun `오답 1개, 볼 2개일 때 볼 2개 반환`() {
        assertCheck("123", "412", 0, 2)
    }

    @Test
    fun `오답 1개, 스트라이크 2개일 때 스트라이크 2개 반환`() {
        assertCheck("123", "423", 2, 0)
    }

    @Test
    fun `볼이 2개, 스트라이크 1개일 때 볼 2개,스트라이크 1개 반환`() {
        assertCheck("123", "132", 1, 2)
    }

    @Test
    fun `볼이 1개, 스트라이크 1개, 오답 1개일 때 볼 1개,스트라이크 1개 반환`() {
        assertCheck("123", "243", 1, 1)
    }



    private fun assertCheck(
        computerInput: String,
        userInput: String,
        expectedStrike: Int,
        expectedBall: Int,
    ) {
        val round = BaseballGame(computerInput)
        val checkStrike = round.strike(userInput)
        val checkBall = round.ball(userInput)
        assertThat(expectedStrike).isEqualTo(checkStrike)
        assertThat(expectedBall).isEqualTo(checkBall)
    }

}