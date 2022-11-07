package baseball

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class UserTest {

    @Test
    fun `서로 다른 숫자 3개 입력 예외 발생`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val input = "1234"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            user.getGuessInput()
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val input = "504"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            user.getGuessInput()
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val input = "112"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            user.getGuessInput()
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val input = "abc"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            user.getGuessInput()
        }
    }

    @Test
    fun `재시작 종료 입력에 대한 예외 발생`() {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            val input = "3"
            val inputStream = ByteArrayInputStream(input.toByteArray())
            System.setIn(inputStream)
            user.getRestartOrNotInput()
        }
        Assertions.assertThrows(IllegalArgumentException::class.java) {
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