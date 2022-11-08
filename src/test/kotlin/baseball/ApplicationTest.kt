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
    fun `숫자 아닌 값 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("abcde") }
        }
    }

    @Test
    fun `999보다 큰 숫자 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }
    @Test
    fun `111보다 작은 숫자 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("85") }
        }
    }

    @Test
    fun `중복되는 숫자 입력 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("155") }
        }
    }

    override fun runMain() {
        main()
    }
}
