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
    fun `게임종료 후 종료`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "245", "641", "346", "2")
                assertThat(output())
                    .contains("2스트라이크", "1스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            3, 4, 6
        )
    }

    @Test
    fun `게임 재시작 1,2 외 정수 입력 오류`() {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException> {run("246", "245", "641", "346", "5")}
            },
            3, 4, 6
        )
    }

    @Test
    fun `게임 재시작 알파벳 입력 오류`() {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException> {run("246", "245", "641", "346", "a")}
            },
            3, 4, 6
        )
    }

    @Test
    fun `게임 재시작 널값 입력 오류`() {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException> {run("246", "245", "641", "346", null)}
            },
            3, 4, 6
        )
    }

    @Test
    fun `길이 초과 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `길이 부족 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1") }
        }
    }

    @Test
    fun `정수외 값 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a34") }
        }
    }

    @Test
    fun `널 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException() }
        }
    }

    @Test
    fun `0 포함 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("012") }
        }
    }

    override fun runMain() {
        main()
    }
}
