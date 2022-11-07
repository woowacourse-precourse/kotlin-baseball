package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `랜덤 세 자리 숫자 생성`(){
        val randomNumber = randomThreeNumber()
        assertThat(randomNumber).hasSize(3)
    }

    @Test
    fun `스트라이크 0개 찾기`(){
        val computer = listOf<Int>(1,4,8)
        val user = listOf<Int>(9,8,4)
        val result = findStrike(computer,user)
        assertThat(result).isEqualTo(0)
    }
    @Test
    fun `스트라이크 1개 찾기`(){
        val computer = listOf<Int>(1,8,3)
        val user = listOf<Int>(2,8,9)
        val result = findStrike(computer,user)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `스트라이크 2개 찾기`(){
        val computer = listOf<Int>(1,2,3)
        val user = listOf<Int>(4,2,3)
        val result = findStrike(computer,user)
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `스트라이크 3개 찾기`(){
        val computer = listOf<Int>(5,6,9)
        val user = listOf<Int>(5,6,9)
        val result = findStrike(computer,user)
        assertThat(result).isEqualTo(3)
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
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    override fun runMain() {
        main()
    }
}
