package baseball

import baseball.view.main
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
    fun `게임 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("132", "651", "615", "1", "312", "213", "123","2")
                assertThat(output())
                    .contains("1볼", "2볼 1스트라이크", "3스트라이크", "3볼", "2볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            6, 1,  5, 1, 2, 3
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `타입 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("asd") }
        }
    }

    @Test
    fun `중복 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("111") }
        }
    }

    @Test
    fun `부분 중복 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("212") }
        }
    }

    override fun runMain() {
        main()
    }
}
