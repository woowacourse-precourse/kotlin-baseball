package baseball

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream

class UserTest {

    @Test
    fun `3자리 이상 입력 시 예외 발생`() {
        assertThrows<IllegalArgumentException>("잘못된 입력입니다.") {
            val input = "1234"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            user.getGuessInput()
        }
    }

    @Test
    fun `0을 포함하는 입력은 예외 발생`() {
        assertThrows<IllegalArgumentException>("잘못된 입력입니다.") {
            val input = "102"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            user.getGuessInput()
        }
    }

    @Test
    fun `중복된 숫자를 포함하는 입력은 예외 발생`() {
        assertThrows<IllegalArgumentException>("잘못된 입력입니다.") {
            val input = "221"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            user.getGuessInput()
        }
    }

    @Test
    fun `숫자가 아닌 입력은 예외 발생`() {
        assertThrows<IllegalArgumentException>("잘못된 입력입니다.") {
            val input = "ab-"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            user.getGuessInput()
        }
    }

    @Test
    fun `재시작 종료 입력에 대한 예외 발생`() {
        assertThrows<IllegalArgumentException>("잘못된 입력입니다.") {
            val input = "3"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            user.getRestartOrNotInput()
        }

        assertThrows<IllegalArgumentException>("잘못된 입력입니다.") {
            val input = "a"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            user.getRestartOrNotInput()
        }
    }

    companion object {
        lateinit var user: User

        @BeforeAll
        @JvmStatic
        internal fun initUser() {
            user = User()
        }
    }
}