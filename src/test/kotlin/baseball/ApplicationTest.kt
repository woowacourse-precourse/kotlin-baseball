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
    fun `3자리가 아닌 수를 입력했을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12345") }
        }
    }

    @Test
    fun `빈칸만 입력했을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ") }
        }
    }

    @Test
    fun `숫자 사이에 빈칸을 입력했을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1 23") }
        }
    }

    @Test
    fun `숫자가 아닌 다른 문자를 입력했을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1a4") }
        }
    }

    @Test
    fun `3자리의 숫자 중 서로 같은 숫자를 입력했을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("122") }
        }
    }

    override fun runMain() {
        main()
    }
}
