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
    fun `예외 테스트 1_숫자가 3자리가 아닌 경우 1`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `예외 테스트 2_숫자가 3자리가 아닌 경우 2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12") }
        }
    }

    @Test
    fun `예외 테스트 3_1~9 사이의 숫자가 아닌 다른 값이 입력된 경우 1_0이 포함된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("012") }
        }
    }

    @Test
    fun `예외 테스트 4_숫자가 아닌 문자가 포함된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12a") }
        }
    }

    @Test
    fun `예외 테스트 5_중복된 숫자가 입력된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("122") }
        }
    }

    override fun runMain() {
        main()
    }
}
