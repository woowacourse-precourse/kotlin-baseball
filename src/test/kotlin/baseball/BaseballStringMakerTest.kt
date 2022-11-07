package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BaseballStringMakerTest {

    @Test
    fun `숫자야구게임 비교 결과 스트링 테스트`() {
        val stringMaker = BaseballStringMaker()
        val user = listOf(3, 5, 8)
        val computer = listOf(3, 7, 5)
        val result = stringMaker.resultCurRound(user, computer)
        assertThat(result).isEqualTo("1볼 1스트라이크 ")
    }
}