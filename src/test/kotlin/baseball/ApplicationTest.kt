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
    fun `유효성 테스트 함수 테스트1`(){
        val par = listOf(1,2,3)
        val result = checkValidNumber(par)
        assertThat(result).isEqualTo(true)
    }
    @Test
    fun `유효성 테스트 함수 테스트2`(){
        val par = listOf(0,2,3)
        val result = checkValidNumber(par)
        assertThat(result).isEqualTo(false)
    }
    @Test
    fun `유효성 테스트 함수 테스트3`(){
        val par = listOf(1,1,3)
        val result = checkValidNumber(par)
        assertThat(result).isEqualTo(false)
    }

    override fun runMain() {
        main()
    }
}
