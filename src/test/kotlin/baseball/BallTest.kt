package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BallTest {


    @Test
    fun ball_number_valid_Test() {
        var ball = Ball(4, 1)
        val result = 4
        assertThat(ball.number).isEqualTo(result)
    }

    @Test
    fun ball_number_invalid_Test() {
        Assertions.assertThrows(IllegalArgumentException::class.java, {
            val ball = Ball(0,1)
        })
    }
}