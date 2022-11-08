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


    /* 입력한 숫자가 조건에 부합하는지 검사 - 3자리인가? */
    @Test
    fun `3자리 이상의 숫자 입력 시 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `3자리 이하의 숫자 입력 시 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12") }
        }
    }

    /* 입력한 숫자가 조건에 부합하는지 검사 - 각 자리의 숫자 범위가 1~9인가? */
    @Test
    fun `범위 밖 숫자 입력 시 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("100") }
        }
    }

    /* 입력한 숫자가 조건에 부합하는지 검사 - 각 자리의 숫자들이 서로 다른가? */
    @Test
    fun `같은 숫자 입력 시 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("111") }
        }
    }

    override fun runMain() {
        main()
    }
}
