package baseball.game.processor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ProcessorTest {
    private val ballStrikeProcessor = BallStrikeProcessor()

    @Test
    fun `모두 스트라이크인 경우 테스트`() {
        assertThat(ballStrikeProcessor.processBallStrike(numberOfComputer = "123", numberOfPlayer = "123")).runCatching {
            assertThat(ballStrikeProcessor.makeBallStateMessage()).isEqualTo("3스트라이크")
            assertTrue(ballStrikeProcessor.isAllStrike())
        }
    }

    @Test
    fun `스트라이크가 있고 볼이 없는 경우 테스트`() {
        assertThat(ballStrikeProcessor.processBallStrike(numberOfComputer = "123", numberOfPlayer = "145")).runCatching {
            assertThat(ballStrikeProcessor.makeBallStateMessage()).isEqualTo("1스트라이크")
            assertFalse(ballStrikeProcessor.isAllStrike())
        }
    }

    @Test
    fun `볼이 있고 스트라이크가 없는 경우 테스트`() {
        assertThat(ballStrikeProcessor.processBallStrike(numberOfComputer = "123", numberOfPlayer = "231")).runCatching {
            assertThat(ballStrikeProcessor.makeBallStateMessage()).isEqualTo("3볼")
            assertFalse(ballStrikeProcessor.isAllStrike())
        }
    }

    @Test
    fun `볼과 스트라이크 모두 있는 경우 테스트`() {
        assertThat(ballStrikeProcessor.processBallStrike(numberOfComputer = "123", numberOfPlayer = "135")).runCatching {
            assertThat(ballStrikeProcessor.makeBallStateMessage()).isEqualTo("1볼 1스트라이크")
            assertFalse(ballStrikeProcessor.isAllStrike())
        }
    }

    @Test
    fun `낫싱인 경우 테스트`() {
        assertThat(ballStrikeProcessor.processBallStrike(numberOfComputer = "123", numberOfPlayer = "456")).runCatching {
            assertThat(ballStrikeProcessor.makeBallStateMessage()).isEqualTo("낫싱")
            assertFalse(ballStrikeProcessor.isAllStrike())
        }
    }
}