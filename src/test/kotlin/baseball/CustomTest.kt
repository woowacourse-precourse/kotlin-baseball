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

    @Test
    fun `길이 3이상 입력시 에러 반환여부 체크`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("6547") }
        }
    }

    @Test
    fun `중복문자 포함시 에러 반환여부 체크`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("644") }
        }
    }

    @Test
    fun `0 포함시 에러 반환여부 체크`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("604") }
        }
    }
}