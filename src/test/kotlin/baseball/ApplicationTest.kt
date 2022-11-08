package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
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

    override fun runMain() {
        main()
    }

    @Test
    fun `사용자가 입력한 숫자 자리수로 끊어서 리스트로 변환`() {
        val input = "123"
        val result = mutableListOf(1, 2, 3)
        assertThat(getPlayerNumbers(input)).isEqualTo(result)
    }

    @Nested
    inner class GettingResultTest {
        @Test
        fun case1() {
            val computer = mutableListOf(3, 5, 7)
            val player = mutableListOf(3, 7, 4)
            val result = Pair(1, 1)
            assertThat(getResult(computer, player)).isEqualTo(result)
        }

        @Test
        fun case2() {
            val computer = mutableListOf(3, 5, 7)
            val player = mutableListOf(5, 7, 3)
            val result = Pair(0, 3)
            assertThat(getResult(computer, player)).isEqualTo(result)
        }

        @Test
        fun case3() {
            val computer = mutableListOf(3, 5, 7)
            val player = mutableListOf(3, 5, 7)
            val result = Pair(3, 0)
            assertThat(getResult(computer, player)).isEqualTo(result)
        }

        @Test
        fun case4() {
            val computer = mutableListOf(3, 5, 7)
            val player = mutableListOf(1, 2, 4)
            val result = Pair(0, 0)
            assertThat(getResult(computer, player)).isEqualTo(result)
        }
    }
}
