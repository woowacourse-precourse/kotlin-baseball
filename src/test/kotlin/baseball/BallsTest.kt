package baseball

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class BallsTest {

    @Test
    fun `입력받은 ballList 길이 예외 테스트`() {
        Assertions.assertThrows(IllegalArgumentException::class.java, {
            val Balls = Balls("3456")
        })
    }
}