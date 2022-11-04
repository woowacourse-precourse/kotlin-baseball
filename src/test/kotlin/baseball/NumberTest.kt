package baseball

import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.assertThrows

class NumberTest : NsTest() {
    @Test
    fun `숫자 예외 테스트1`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `숫자 예외 테스트2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("120") }
        }
    }

    @Test
    fun `숫자 예외 테스트3`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12m") }
        }
    }

    @Test
    fun `숫자 예외 테스트4`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("112") }
        }
    }

    override fun runMain() {
        main()
    }
}