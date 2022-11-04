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

}