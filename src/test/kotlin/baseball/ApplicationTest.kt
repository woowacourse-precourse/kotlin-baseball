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

        assertRandomNumberInRangeTest(
                {
                    run("369", "147", "1", "258", "825", "1", "951", "159", "2")
                    assertThat(output())
                            .contains("낫싱", "3스트라이크", "3볼", "3스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료")
                },
                1, 4, 7, 8, 2, 5, 1, 5, 9
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12r") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1 2") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("012") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("-123") }
        }
    }


    override fun runMain() {
        main()
    }
}
