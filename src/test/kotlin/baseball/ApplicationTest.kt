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
    fun `볼만 있는 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "986", "816", "168", "2")
                assertThat(output())
                    .contains("1볼", "2볼", "3볼", "게임 종료")
            },
            1, 6,8
        )
    }
    @Test
    fun `스트라이크만 있는 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("912", "256", "956", "2")
                assertThat(output())
                    .contains("1스트라이크", "2스트라이크", "3스트라이크", "게임 종료")
            },
            9,5,6
        )
    }
    @Test
    fun `볼, 스트라이크 둘 다 있는 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("712", "197", "791", "2")
                assertThat(output())
                    .contains("1볼 1스트라이크", "2볼 1스트라이크", "게임 종료")
                // 1볼 2스트라이크는 불가능
            },
            7,9,1
        )
    }
    @Test
    fun `볼, 스트라이크 둘 다 없는 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("145", "986", "273", "2")
                assertThat(output())
                    .contains("낫싱", "낫싱", "게임 종료")
                // 1볼 2스트라이크는 불가능
            },
            2,7,3
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    override fun runMain() {
        main()
    }
}
