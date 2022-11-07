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

    override fun runMain() {
        main()
    }
}