package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

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