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
    fun `재시작 없이 게임`() {
        assertRandomNumberInRangeTest(
            {
                run("354", "257", "934", "678", "346", "564", "346", "364", "2")
                assertThat(output())
                    .contains("1스트라이크", "낫싱", "1볼 1스트라이크", "1볼", "2볼 1스트라이크", "2스트라이크",
                        "2볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            3, 6, 4
        )
    }
    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }


    @Test
    fun `중복 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("112") }
        }
    }

    override fun runMain() {
        main()
    }
}
