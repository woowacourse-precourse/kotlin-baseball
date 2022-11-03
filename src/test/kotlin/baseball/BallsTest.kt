package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class BallsTest {

    val com = Balls("123")
    @Test
    fun `입력받은 ballList 길이 예외 테스트`() {
        Assertions.assertThrows(IllegalArgumentException::class.java, {
            val Balls = Balls("3456")
        })
    }

    @Test
    fun `balls이 스트라이크인지 확인`() {
        val ball = Ball(1, 1)
        val result = "Strike"
        assertThat(com.playGame(ball)).isEqualTo(result)
    }

    @Test
    fun `balls이 볼인지 확인`() {
        val ball = Ball(2, 1)
        val result = "Ball"
        assertThat(com.playGame(ball)).isEqualTo(result)
    }

    @Test
    fun `balls이 낫싱인지 확인`() {
        val ball = Ball(4, 1)
        val result = "Nothing"
        assertThat(com.playGame(ball)).isEqualTo(result)
    }

    @Test
    fun playGame() {
        var userInput = "123"
        assertThat(com.playGame(userInput).strike).isEqualTo(3)
        assertThat(com.playGame(userInput).ball).isEqualTo(0)

        userInput = "456"
        assertThat(com.playGame(userInput).strike).isEqualTo(0)
        assertThat(com.playGame(userInput).ball).isEqualTo(0)

        userInput = "132"
        assertThat(com.playGame(userInput).strike).isEqualTo(1)
        assertThat(com.playGame(userInput).ball).isEqualTo(2)

    }
}