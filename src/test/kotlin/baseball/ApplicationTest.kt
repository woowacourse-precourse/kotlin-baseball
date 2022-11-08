package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `테스트 1 정답을 맞춘 후 2를 누르면 게임이 종료되는지 확인`() {
        assertRandomNumberInRangeTest(
            {
                run("135", "2")
                assertThat(output())
                    .contains("3스트라이크", "게임 종료")
            },
            1, 3, 5
        )
    }

    @Test
    fun `테스트 2 정답을 맞춘 후 1을 누르면 재시작하는지 확인`() {
        assertRandomNumberInRangeTest(
            {
                run("135", "1", "567", "2")
                assertThat(output())
                    .contains("3스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 6, 7
        )
    }

    @Test
    fun `테스트 3 볼, 스트라이크 정확히 맞추는지 확인`() {
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
    fun `테스트 4 입력이 세자리수가 아닌 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `테스트 5 입력에 같은 숫자가 있을 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("122") }
        }
    }

    @Test
    fun `테스트 6 입력에 0이 들어있는 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("120") }
        }
    }

    @Test
    fun `테스트 7 입력이 널인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(null) }
        }
    }

    @Test
    fun `테스트 8 입력에 1~9가 아닌 문자가 들어있을 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12a") }
        }
    }

    @Test
    fun `테스트 9 입력에 1~9가 아닌 문자가 들어있을 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12a") }
        }
    }

    @Test
    fun `테스트 10 게임 재시작 질문에서 잘못된 값 입력 시 테스트`() {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException> { runException("135", "3") }
            },
            1, 3, 5
        )
    }

    @Test
    fun `테스트 11 isThreeDigitNum 동작`() {
        val result = isThreeDigitNum(99)
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `테스트 12 existZero 동작`() {
        val result = existZero(150)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `테스트 13 isDifferentNum 동작`() {
        val result = isDifferentNum(266)
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `테스트 14 printResult 동작`() {
        printResult(Pair(0, 3))
        assertThat(output()).contains("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    override fun runMain() {
        main()
    }
}
