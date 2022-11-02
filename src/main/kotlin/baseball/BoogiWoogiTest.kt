package baseball

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BoogiWoogiTest {
    @Test
    fun `사용자의 입력이 숫자가 아닌 경우 예외 발생`(){
        assertThrows<IllegalArgumentException> {
            checkException("우테코 합격기원")
        }
    }

    @Test
    fun `사용자의 입력이 세자리가 아닌 경우 예외 발생`(){
        assertThrows<IllegalArgumentException> {
            checkException("7777")
        }
    }

}