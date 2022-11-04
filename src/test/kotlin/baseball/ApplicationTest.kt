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
    fun `resultNum 범위 테스트`(){
        var start = 0
        var end = 0
        repeat(RESULT_NUM_RANGE) {
            start = start * 10 + 1
            end = end * 10 + 9
        }
        assertThat(getResultRange() == Pair(start,end))
    }

    @Test
    fun `range validation 테스트`(){
        if(RESULT_NUM_RANGE in 1 .. 9){
            assertThat(validateRange())
        }else{
            assertThrows<IllegalArgumentException> { validateRange() }
        }
    }

    @Test
    fun `resultNum range validation 테스트`(){
        val (start, end ) = getResultRange()
        assertThat(getResultNum() in start .. end)
    }

    override fun runMain() {
        main()
    }
}
