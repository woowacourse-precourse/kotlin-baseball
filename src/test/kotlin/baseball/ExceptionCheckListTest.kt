package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionCheckListTest {

    @Test
    fun `입력된 문자가 숫자가 아니면 예외 발생`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { isInteger("98ㄱ12") }
        }
    }
}