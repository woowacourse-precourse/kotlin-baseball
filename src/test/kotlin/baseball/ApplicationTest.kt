package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
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
    fun `게임 볼, 스트라이크 값 체크`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
            {
                run("456", "671", "321", "129", "139","123","2")
                Assertions.assertThat(output())
                    .contains("낫싱", "1볼", "2볼 1스트라이크", "2스트라이크", "1볼 1스트라이크","3스트라이크","게임 종료")
            },
            1, 2, 3
        )
    }

    @Test
    fun `예외 테스트1_3자리가 아닌 수`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }
    @Test
    fun `예외 테스트2_0이 포함된 수`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("109") }
        }
    }

    @Test
    fun `예외 테스트3_중복된 수가 있는 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("119") }
        }
    }
    @Test
    fun `예외 테스트4_Int가 아닐 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("hello") }
        }
    }

    @Test
    fun `예외 테스트5_공백 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("") }
        }
    }

    @Test
    fun `예외 테스트6_엔터 입력`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("\n") }
        }
    }

    override fun runMain() {
        main()
    }
}
