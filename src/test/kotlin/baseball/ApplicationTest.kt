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
    fun `게임 종료`() {
        assertRandomNumberInRangeTest(
            {
                run("123", "2")
                assertThat(output())
                    .contains("3스트라이크", "게임 종료")
            },
            1, 2, 3
        )
    }

    @Test
    fun `게임 정상 출력`() {
        assertRandomNumberInRangeTest(
            {
                run("789", "189", "129", "241", "489", "419", "192", "214", "412", "2")
                assertThat(output())
                    .contains("낫싱", "1볼", "2볼", "3볼", "1스트라이크", "2스트라이크", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            4, 1, 2
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `예외 테스트_한 문자 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1") }
        }
    }

    @Test
    fun `예외 테스트_알파벳 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("abc") }
        }
    }

    @Test
    fun `예외 테스트_한글 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("가나다") }
        }
    }

    @Test
    fun `예외 테스트_특수문자 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("!@#") }
        }
    }

    @Test
    fun `예외 테스트_중복 문자 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("122") }
        }
    }


    override fun runMain() {
        main()
    }
}
