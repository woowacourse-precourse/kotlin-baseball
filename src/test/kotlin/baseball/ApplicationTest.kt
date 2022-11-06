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

    override fun runMain() {
        main()
    }

    @Test
    fun `setComputerNumTest`() {
        assertRandomNumberInRangeTest(
            {
                val computerNum = setComputerNum()
                assertThat(computerNum).isEqualTo(mutableListOf<Int>(1,3,5))
            },
            1,3,5
        )
    }

    @Test
    fun `changeIntToMutableListInt` () {
        val input = 135
        assertThat(baseball.changeIntToMutableListInt(input)).isEqualTo(mutableListOf(1,3,5))
    }

    @Test
    fun `inputNumTest`(){
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputNum("1234")}
        }
        assertThat(inputNum("135")).isEqualTo(mutableListOf(1,3,5))
    }
    
    @Test
    fun `isInputAnswerTest`() {
        val computerNum = mutableListOf(1,3,5)
        val playerInput = mutableListOf(1,3,5)
        val playerInput2 = mutableListOf(2,4,6)
        assertThat(isInputAnswer(computerNum, playerInput)).isEqualTo(true)
        assertThat(isInputAnswer(computerNum, playerInput2)).isEqualTo(false)
    }
}
