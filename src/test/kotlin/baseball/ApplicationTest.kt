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
    fun `range validation 테스트`() {
        if (RESULT_NUM_LENGTH in 1..9) {
            assertThat(validateRange())
        } else {
            assertThrows<IllegalArgumentException> { validateRange() }
        }
    }

    @Test
    fun `getResultNum 테스트`() {
        val resultNum = getResultNum()
        assertThat(
            resultNum.toString().length == resultNum.toString().toCharArray().distinct().size
        )
    }

    @Test
    fun `matchResult 테스트`(){
        val list = arrayOf(
            Pair(0, 0),
            Pair(0, 2),
            Pair(2, 0),
            Pair(3, 0),
            Pair(0, 3),
        )
        val result = arrayOf(
            false, false, false, false, true
        )
        for (i in list.indices) {
            val (ballCnt, strikeCnt) = list[i]
            assertThat(matchResult(ballCnt, strikeCnt) == result[i])
        }
    }

    @Test
    fun `exit code validation 테스트`() {
        val input = "abc"
        when {
            input.isBlank() -> assertThrows<IllegalArgumentException> { input.mappingExitCode() }
            input[0] == '1' -> assertThat(!input.mappingExitCode())
            input[1] == '2' -> assertThat(input.mappingExitCode())
            else -> assertThrows<IllegalArgumentException> { input.mappingExitCode() }
        }
    }

    @Test
    fun `input number validation 테스트`() {
        val input = "9999"
        try {
            when {
                input.isBlank() -> assertThrows<IllegalArgumentException> { input.mappingInputNumber() }
                input.length == RESULT_NUM_LENGTH -> assertThat(input.mappingInputNumber())
                else -> assertThrows<IllegalArgumentException> { input.mappingInputNumber() }
            }
        } catch (e: Exception) {
            assertThrows<IllegalArgumentException> { input.mappingInputNumber() }
        }
    }


    override fun runMain() {
        main()
    }
}
