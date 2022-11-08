package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
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







    override fun runMain() {
        main()
    }
}