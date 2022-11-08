package baseball


import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test fun `예외 테스트2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("룰루랄라") }
        }
    }

}
