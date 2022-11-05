package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CorrectAnswerTest {
    @Test
    fun `모두 스트라이크일 때 스트라이크 3개 반환`() {
        val round = BaseballGame("123")
        val checkStrike = round.strike("123")
        assertThat(3).isEqualTo(checkStrike)
    }

    @Test
    fun `모두 볼일 때 볼 3개 반환`() {
        val round = BaseballGame("123")
        val checkBall = round.ball("321")
        assertThat(3).isEqualTo(checkBall)
    }

    @Test
    fun `모두 오답일 때 낫싱을 반환`() {
        val round = BaseballGame("123")
        val checkStrike = round.strike("456")
        val checkBall = round.ball("456")
        assertThat(0).isEqualTo(checkStrike)
        assertThat(0).isEqualTo(checkBall)

    }

}