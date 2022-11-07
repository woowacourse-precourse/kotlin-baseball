package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BallTest {

    val ball = Ball(4, 1)

    @Test
    fun ball_number_valid_Test() {
        val result = 4
        assertThat(ball.number).isEqualTo(result)
    }

    @Test
    fun ball_number_invalid_Test() {
        Assertions.assertThrows(IllegalArgumentException::class.java, {
            val ball = Ball(0,1)
        })
    }

    @Test
    fun `ball이 스트라이크인지 확인`() {
        val userBall = Ball(4, 1)
        val result = Result.STRIKE
        assertThat(ball.playGame(userBall)).isEqualTo(result)
    }

    @Test
    fun `ball이 볼인지 확인`() {
        val userBall = Ball(4, 2)
        val result = Result.BALL
        assertThat(ball.playGame(userBall)).isEqualTo(result)
    }

    @Test
    fun `ball이 낫싱인지 확인`() {
        val userBall = Ball(2, 1)
        val result = Result.NOTHING
        assertThat(ball.playGame(userBall)).isEqualTo(result)
    }
}