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

    @Test
    fun `정수 list 변환 함수 테스트`(){
        val result = makeNumToList(123)
        val par = listOf(1,2,3)
        assertThat(result).isEqualTo(par)
    }

    @Test
    fun `strike,ball 세는 함수 테스트1`(){
        val par1 = listOf(1,2,3)
        val result = countStrikeBall(par1,par1)
        assertThat(result).isEqualTo(Pair(3,0))
    }

    @Test
    fun `strike,ball 세는 함수 테스트2`(){
        val par1 = listOf(1,2,3)
        val par2 = listOf(1,2,7)
        val result = countStrikeBall(par1,par2)
        assertThat(result).isEqualTo(Pair(2,0))
    }

    @Test
    fun `strike,ball 세는 함수 테스트3`(){
        val par1 = listOf(1,2,3)
        val par2 = listOf(1,9,7)
        val result = countStrikeBall(par1,par2)
        assertThat(result).isEqualTo(Pair(1,0))
    }

    @Test
    fun `strike,ball 세는 함수 테스트4`(){
        val par1 = listOf(1,2,3)
        val par2 = listOf(9,8,7)
        val result = countStrikeBall(par1,par2)
        assertThat(result).isEqualTo(Pair(0,0))
    }

    @Test
    fun `strike,ball 세는 함수 테스트5`(){
        val par1 = listOf(1,2,3)
        val par2 = listOf(1,7,2)
        val result = countStrikeBall(par1,par2)
        assertThat(result).isEqualTo(Pair(1,1))
    }

    @Test
    fun `strike,ball 세는 함수 테스트6`(){
        val par1 = listOf(1,2,3)
        val par2 = listOf(1,3,2)
        val result = countStrikeBall(par1,par2)
        assertThat(result).isEqualTo(Pair(1,2))
    }

    @Test
    fun `strike,ball 세는 함수 테스트7`(){
        val par1 = listOf(1,2,3)
        val par2 = listOf(2,3,7)
        val result = countStrikeBall(par1,par2)
        assertThat(result).isEqualTo(Pair(0,2))
    }

    @Test
    fun `strike,ball 세는 함수 테스트8`(){
        val par1 = listOf(1,2,3)
        val par2 = listOf(7,1,8)
        val result = countStrikeBall(par1,par2)
        assertThat(result).isEqualTo(Pair(0,1))
    }

    @Test
    fun `strike,ball 세는 함수 테스트9`(){
        val par1 = listOf(1,2,3)
        val par2 = listOf(3,1,2)
        val result = countStrikeBall(par1,par2)
        assertThat(result).isEqualTo(Pair(0,3))
    }

    override fun runMain() {
        main()
    }
}
