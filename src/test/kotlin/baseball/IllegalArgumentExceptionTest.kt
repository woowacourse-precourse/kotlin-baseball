package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class IllegalArgumentExceptionTest : NsTest() {

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
            assertThrows<IllegalArgumentException> { runException("121") }
            assertThrows<IllegalArgumentException> { runException("021") }
            assertThrows<IllegalArgumentException> { runException("130") }
        }
    }

    override fun runMain() {
        main()
    }
}
