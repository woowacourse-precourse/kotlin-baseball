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
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `컴퓨터가 설정한 조건에 따라 숫자를 선택했는지`() {
        assertThat(makeComputerChoose())
            .hasSize(3)
            .doesNotContain(0)
    }

    @Test
    fun `사용자가 입력한 숫자를 올바른 형태로 split 했는지`() {
        assertThat(java.util.Arrays.toString(splitNum(123)))
            .isEqualTo("[1, 2, 3]")
    }

    @Test
    fun `사용자 입력 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12345") }
            assertThrows<IllegalArgumentException> { runException("4566") } // set으로 바꾸면 size가 3이 되지만 네자리수인 수
            assertThrows<IllegalArgumentException> { runException("607") }
        }
    }

    @Test
    fun `게임 종료 이후 질문에서 잘못된 값을 입력했는지`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("5") }
        }
    }

    @Test
    fun `결과 출력 테스트`() {
        assertThat(printResult(1, 1)).isEqualTo("1볼 1스트라이크")
        assertThat(printResult(0, 1)).isEqualTo("1볼")
        assertThat(printResult(1, 0)).isEqualTo("1스트라이크")
        assertThat(printResult(0, 0)).isEqualTo("낫싱")
    }

    override fun runMain() {
        main()
    }
}
