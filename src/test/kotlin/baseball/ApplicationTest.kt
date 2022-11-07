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
    fun compareListTest(){
        val userInputToInt: List<Int> = listOf(1,2,3)
        val computerList: List<Int> = listOf(1,2,3)
        assertThat(compareList(userInputToInt,computerList))
            .isEqualTo(true)
    }

    @Test
    fun ballCheckTest0(){
        val userIn: Int = 1
        val computerList: List<Int> = listOf(1,2,3)
        assertThat(ballCheck(userIn,computerList))
            .isEqualTo(1)
    }
    @Test
    fun ballCheckTest1(){
        val userIn: Int = 9
        val computerList: List<Int> = listOf(1,2,3)
        assertThat(ballCheck(userIn,computerList))
            .isEqualTo(0)
    }

    @Test
    fun `재시작 메뉴 테스트`(){
        val menu: Int = 1
        assertThat(restart(menu))
            .isEqualTo(true)
    }
    @Test
    fun `재시작 메뉴 테스트1`(){
        val menu: Int = 2
        assertThat(restart(menu))
            .isEqualTo(false)
    }

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
    fun `예외 테스트0`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `예외 테스트1`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("str") }
        }
    }

    override fun runMain() {
        main()
    }
}
