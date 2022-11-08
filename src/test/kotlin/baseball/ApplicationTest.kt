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
    fun `3자리인지, 1~9사이 인지, 중복은 없는지 난수 테스트`() {
        val numList = getComputerNumbers()
        assertThat(numList)
            .hasSize(3)
            .allMatch { it in 1..9 }
            .isEqualTo(numList.distinct())
    }

    @Test
    fun `사용자 입력 예외 테스트`() {
        assertThrows<IllegalArgumentException>{
            checkPlayerInput("1234")
            checkPlayerInput("a12")
            checkPlayerInput("121")
        }
    }

    @Test
    fun `스트라이크 판정 테스트`() {
        val computer: List<Int> = listOf(1, 2, 3)

        assertThat(checkStrike(computer, listOf(1, 2, 3))).isEqualTo(false)
        assertThat(checkStrike(computer, listOf(2, 1, 3))).isEqualTo(true)
    }

    @Test
    fun `결과 출력 테스트`() {
        assertThat(getResultString(0,0)).isEqualTo("낫싱")
        assertThat(getResultString(1,0)).isEqualTo("1볼")
        assertThat(getResultString(3,0)).isEqualTo("3볼")
        assertThat(getResultString(0,1)).isEqualTo("1스트라이크")
        assertThat(getResultString(0,3)).isEqualTo("3스트라이크\n" + "3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        assertThat(getResultString(1,2)).isEqualTo("1볼 2스트라이크")
    }

    override fun runMain() {
        main()
    }
}
