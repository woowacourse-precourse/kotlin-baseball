package baseball

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomTest : NsTest() {
    override fun runMain() {
        main()
    }

    @Test
    fun `문자열 포함시 에러 반환여부 체크`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("6r4") }
        }
    }
}