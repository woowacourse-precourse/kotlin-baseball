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
    fun `긴 하나의 게임`() {
        assertRandomNumberInRangeTest(
            {
                run("135", "486", "753", "196", "413", "415", "136", "356", "156", "516", "2")
                assertThat(output())
                    .contains("2볼", "1스트라이크", "1볼", "1볼 1스트라이크", "1스트라이크", "1볼 1스트라이크", "1볼 1스트라이크",
                        "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            5, 1, 6
        )
    }

    @Test
    fun `입력한 세개 숫자 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
            assertThrows<IllegalArgumentException> { runException("12") }
            assertThrows<IllegalArgumentException> { runException("021") }
            assertThrows<IllegalArgumentException> { runException("444") }
        }
    }
    @Test
    fun `게임종료 후 예외 테스트`() {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException> { runException("516", "3") }
            },
            5, 1, 6
        )
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException> { runException("516", "4") }
            },
            5, 1, 6
        )
    }

    override fun runMain() {
        main()
    }
}
