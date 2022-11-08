package baseball

import baseball.model.BaseBall
import baseball.view.OutputView
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class NumberTest : NsTest() {
    @Test
    fun `숫자 예외 테스트1`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `숫자 예외 테스트2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("120") }
        }
    }

    @Test
    fun `숫자 예외 테스트3`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12m") }
        }
    }

    @Test
    fun `숫자 예외 테스트4`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("112") }
        }
    }

    @Test
    fun `스트라이크 개수 확인 테스트`() {
        val computerNumbers = listOf(1, 3, 5)
        val playerNumbers = listOf(2, 3, 5)
        assertThat(BaseBall(computerNumbers, playerNumbers).getStrikeCount()).isEqualTo(2)
    }

    @Test
    fun `볼 개수 확인 테스트`() {
        val computerNumbers = listOf(1, 3, 5)
        val playerNumbers = listOf(2, 5, 3)
        assertThat(BaseBall(computerNumbers, playerNumbers).getBallCount()).isEqualTo(2)
    }

    @Test
    fun `스트라이크 볼 출력 결과 테스트`() {
        OutputView().printResult(1, 2)
        assertThat(output()).isEqualTo("1볼 2스트라이크")
    }

    @Test
    fun `스트라이크 출력 결과 테스트`() {
        OutputView().printResult(0, 2)
        assertThat(output()).isEqualTo("2스트라이크")
    }

    @Test
    fun `볼 출력 결과 테스트`() {
        OutputView().printResult(1, 0)
        assertThat(output()).isEqualTo("1볼")
    }

    @Test
    fun `낫싱 출력 결과 테스트`() {
        OutputView().printResult(0, 0)
        assertThat(output()).isEqualTo("낫싱")
    }

    override fun runMain() {
        main()
    }
}