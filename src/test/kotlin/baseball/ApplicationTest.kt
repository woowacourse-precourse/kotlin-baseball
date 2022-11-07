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
    fun `예외 테스트(타입이 다를 경우)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("abc") }
        }
    }

    @Test
    fun `예외 테스트(입력값에 숫자가 아닌 다른 타입이 있는 경우)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12a") }
        }
    }

    @Test
    fun `예외 테스트(입력값에 띄어쓰기가 있는 경우)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12 3") }
        }
    }

    @Test
    fun `예외 테스트(서로 다른 수를 입력하지 않은 경우)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("111") }
        }
    }
    override fun runMain() {
        main()
    }
}
