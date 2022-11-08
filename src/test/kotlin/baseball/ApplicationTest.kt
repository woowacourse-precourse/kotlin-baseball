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
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            }, 1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `게임 시작 메시지 출력 테스트`() {
        printGameStartText()
        val result = "숫자 야구 게임을 시작합니다."
        assertThat(output()).isEqualTo(result)
    }

    @Nested
    inner class ComputerTest {
        private val computerNumberList = mutableListOf<Int>()

        @Test
        fun `컴퓨터 난수로 생성된 숫자 개수 및 중복 테스트`() {
            inputComputerNumbers(computerNumberList)
            assertThat(computerNumberList.size).isEqualTo(3)
            assertThat(computerNumberList.size).isEqualTo(computerNumberList.toSet().size)
        }
    }




    override fun runMain() {
        main()
    }
}
