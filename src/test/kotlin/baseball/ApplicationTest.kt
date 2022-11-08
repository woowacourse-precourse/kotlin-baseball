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
    fun `바로 3스트라이크`() {
        assertRandomNumberInRangeTest(
            {
                run("531", "2")
                assertThat(output())
                    .contains("3스트라이크", "게임 종료")
            },
            5, 3, 1
        )
    }

    @Test
    fun `자릿수 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `문자 입력 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("@LI") }
        }
    }

    override fun runMain() {
        main()
    }
}
