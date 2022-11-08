package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class UserTest : NsTest() {

    @Test
    fun `user값의 길이가 3이 아닐경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1") }
        }
    }

    @Test
    fun `user값이 숫자가 아닐 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("가나다") }
        }
    }

    @Test
    fun `user값이 0이 있을 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("102") }
        }
    }

    @Test
    fun `user가 중복 숫자를 입력할 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("112") }
        }
    }

    override fun runMain() {
        main()
    }
}
