package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MyGameTest : NsTest() {
    @Test
    fun `사용자 입력 숫자에 0이 포함되는지 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("012") }
        }
    }

    @Test
    fun `사용자 입력 숫자가 3자리 수 인지 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("23") }
        }
    }


    @Test
    fun `사용자 입력 숫자가 3자리 수 중 중복된 숫자가 있는지 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("191") }
        }
    }

    @Test
    fun `사용자 입력 값이 모두 숫자인지 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("13a") }
        }
    }


    @Test
    fun `게임 1회 후 사용자 입력 2이후 게임 완전 종료 테스트`(){
        assertRandomNumberInRangeTest(
            {
                run("135", "246", "879", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "게임 종료")
            },
            8, 7, 9
        )
    }







    override fun runMain() {
        main()
    }
}