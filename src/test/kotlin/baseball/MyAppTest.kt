package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MyAppTest : NsTest() {
    @Test
    fun `게임종료 후 재시작2`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "351", "135", "1", "597", "598", "589", "2")
                Assertions.assertThat(output())
                    .contains("낫싱", "3볼", "3스트라이크", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `예외 테스트2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("113") }
        }
    }
    @Test
    fun `예외 테스트3`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("120") }
        }
    }

    override fun runMain() {
        main()
    }
}