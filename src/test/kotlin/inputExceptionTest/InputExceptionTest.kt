package inputExceptionTest
import Exception.InputException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputExceptionTest {
    @Test
    fun `입력이 숫자가 아닌 문자일 경우`(){
        assertThrows<IllegalArgumentException> {
            InputException().notNumberException("abc")
        }
    }

    @Test
    fun `입력이 3자리 숫자가 아닐 경우`(){
        assertThrows<IllegalArgumentException> {
            InputException().rangeException("1234")
        }
    }

    @Test
    fun `입력이 중복되어 입력되었을 경우`(){
        assertThrows<IllegalArgumentException> {
            InputException().duplicateException("133")
        }
    }

    @Test
    fun `재시작 또는 종료 입력이 아닐 경우`(){
        assertThrows<IllegalArgumentException> {
            InputException().chooseException("3")
        }
    }

}