package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `게임종료 후 재시작`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "135", "1", "597", "589", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `사용자가 숫자가 아닌 값을 입력했을 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("=-[") }
        }
    }

    @Test
    fun `사용자가 3보다 적거나 많은 수의 값을 입력했을 경우` () {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1") }
            assertThrows<IllegalArgumentException> { runException("12345") }
        }
    }

    @Test
    fun `사용자가 입력한 값 중 중복 값이 포함되었을 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("112") }
        }
    }

    override fun runMain() {
        main()
    }
}
