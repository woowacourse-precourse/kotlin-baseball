package baseball

import baseball.src.checkBall
import baseball.src.checkStrike
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProcessorTest {

    @Test
    fun `3스트라이크`() {
        assertThat(checkBall(computer = mutableListOf(1,2,3), user = mutableListOf(1,2,3)))
            .isEqualTo(0)
        assertThat(checkStrike(computer = mutableListOf(1,2,3), user = mutableListOf(1,2,3)))
            .isEqualTo(3)
        }

    @Test
    fun `2스트라이크`() {
        assertThat(checkBall(computer = mutableListOf(1,2,3), user = mutableListOf(1,2,4)))
            .isEqualTo(0)
        assertThat(checkStrike(computer = mutableListOf(1,2,3), user = mutableListOf(1,2,4)))
            .isEqualTo(2)
    }

    @Test
    fun `1스트라이크`() {
        assertThat(checkBall(computer = mutableListOf(1,2,3), user = mutableListOf(1,4,5)))
            .isEqualTo(0)
        assertThat(checkStrike(computer = mutableListOf(1,2,3), user = mutableListOf(1,4,5)))
            .isEqualTo(1)
    }
    @Test
    fun `3볼`() {
        assertThat(checkBall(computer = mutableListOf(1,2,3), user = mutableListOf(3,1,2)))
            .isEqualTo(3)
        assertThat(checkStrike(computer = mutableListOf(1,2,3), user = mutableListOf(3,1,2)))
            .isEqualTo(0)
    }

    @Test
    fun `1스트라이크 2볼`() {
        assertThat(checkBall(computer = mutableListOf(1,2,3), user = mutableListOf(3,2,1)))
            .isEqualTo(2)
        assertThat(checkStrike(computer = mutableListOf(1,2,3), user = mutableListOf(3,2,1)))
            .isEqualTo(1)
    }

    @Test
    fun `낫싱`() {
        assertThat(checkBall(computer = mutableListOf(1,2,3), user = mutableListOf(4,5,6)))
            .isEqualTo(0)
        assertThat(checkStrike(computer = mutableListOf(1,2,3), user = mutableListOf(4,5,6)))
            .isEqualTo(0)
    }

    }


