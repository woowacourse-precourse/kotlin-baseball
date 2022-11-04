package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class GameManagerTest {
    private val gameManager = GameManager()

    @Test
    fun `볼 개수 반환`() {
        val userNumber = listOf(1, 2, 3)
        val computerNumber = listOf(2, 3, 4)
        assertThat(gameManager.countBall(userNumber, computerNumber)).isEqualTo(2)
    }

    @Test
    fun `스트라이크 개수 반환`() {
        val userNumber = listOf(1, 2, 3)
        val computerNumber = listOf(1, 3, 4)
        assertThat(gameManager.countStrike(userNumber, computerNumber)).isEqualTo(1)
    }

    @Test
    fun `최종 스트라이크,볼 개수 반환`() {
        val userNumber = listOf(1, 2, 3)
        val computerNumber = listOf(1, 3, 4)
        var ball = gameManager.countBall(userNumber, computerNumber)
        val strike = gameManager.countStrike(userNumber, computerNumber)
        ball = gameManager.getFinalBallCount(ball, strike)
        assertThat(ball).isEqualTo(1)
        assertThat(strike).isEqualTo(1)
    }
}