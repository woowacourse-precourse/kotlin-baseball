package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.util.Collections.max
import java.util.Collections.min

class FunctionTest : NsTest() {

    @Test
    fun `컴퓨터의 랜덤값 유효 확인`() {
        val randomNum = createComputerNumber()
        assertThat(
            checkLength(randomNum)
                    && checkRange(randomNum)
                    && checkDuplication(randomNum)
        )
    }

    @Test
    fun `여러 가지 경우의 결과`() {
        assertRandomNumberInRangeTest(
            {
                run("123", "712", "738", "478", "768", "879", "876", "2")
                assertThat(output())
                    .contains("낫싱", "1볼", "2볼", "1볼 1스트라이크", "3볼", "2스트라이크", "3스트라이크", "게임 종료")
            },
            8, 7, 6
        )
    }

    @Test
    fun `재시작 예외 테스트`() {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException> { run("123", "231", "12") }
            },
            2, 3, 1
        )
    }

    @Test
    fun `입력값 길이가 3이 아닌 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("98") }
        }
    }

    @Test
    fun `입력값이 숫자가 아닌 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1ab") }
        }
    }

    @Test
    fun `입력값에 0이 들어가는 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("803") }
        }
    }

    @Test
    fun `입력값에 중복값이 들어가는 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("141") }
        }
    }

    override fun runMain() {
        main()
    }

    private fun checkRange(randomNum: MutableList<Int>): Boolean {
        if ((min(randomNum) >= 1) && (max(randomNum) <= 9))
            return true
        return false
    }

    private fun checkLength(randomNum: MutableList<Int>): Boolean {
        if (randomNum.size == 3)
            return true
        return false
    }

    private fun checkDuplication(randomNum: MutableList<Int>): Boolean {
        if (randomNum.distinct().size == 3)
            return true
        return false
    }
}