package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CorrectAnswerTest {
    @Test
    fun `모두 스트라이크일 때 점수가 3인지 확인`() {
        val round = BaseballGame("123")
        val checkStrike = round.strike("123")
        assertThat(3).isEqualTo(checkStrike)
    }
}