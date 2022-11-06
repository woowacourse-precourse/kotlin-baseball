package baseball

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultTest : NsTest() {

    private var result = Result()

    @Test
    fun `ball 개수 계산 검증`() {
        result.getScore("123", "234")
        assertThat(result.ball).isEqualTo(2)
    }

    @Test
    fun `strike 개수 계산 검증`() {
        result.getScore("123", "123")
        assertThat(result.strike).isEqualTo(3)
    }

    @Test
    fun `ball, strike 개수 출력 검증`() {
        result.printResult(2, 2)
        assertThat(output())
            .isEqualTo("2볼 2스트라이크")
    }

    override fun runMain() {
        main()
    }
}
