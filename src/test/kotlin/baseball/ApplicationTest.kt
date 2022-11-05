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
    fun `난수 자릿수 테스트`() {
        assertThat(getComputerNumbers().size).isEqualTo(3)
    }

    @Test
    fun `난수 범위 확인 테스트`(){
        val list: List<Int> = getComputerNumbers()

        for (i in 0..2) {
            assertThat(list[i]).isBetween(0, 9)
        }
    }

    @Test
    fun `난수 중복 테스트`() {
        val list: List<Int> = getComputerNumbers()

        for (i in 0..2) {
            assertThat(list.count { it == list[i] }).isEqualTo(1)
        }
    }

    @Test
    fun `사용자 입력 자릿수 테스트`() {
        assertThat(getPlayerNumbers().size).isEqualTo(3)
    }

    @Test
    fun `사용자 입력 번위 확인 테스트`(){
        val list: List<Int> = getPlayerNumbers()

        for (i in 0..2) {
            assertThat(list[i]).isBetween(0, 9)
        }
    }

    @Test
    fun `사용자 입력 중복 테스트`() {
        val list: List<Int> = getPlayerNumbers()

        for (i in 0..2) {
            assertThat(list.count { it == list[i] }).isEqualTo(1)
        }
    }

    override fun runMain() {
        main()
    }
}
