package baseball

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameControllerTest {
    @Test
    fun `사용자의 중복된 숫자 입력 예외`() {
        val userList = listOf(1, 1, 2)
        assertThrows<IllegalArgumentException> {
            GameController.exception(userList)
        }
    }

    @Test
    fun `사용자의 범위를 넘어간 숫자 입력 예외`() {
        val userList = listOf(10, 1, -1)
        assertThrows<IllegalArgumentException> {
            GameController.exception(userList)
        }
    }

    @Test
    fun `사용자의 리스트 크기를 벗어난 입력 예외`() {
        val userList = listOf(1, 1, 2, 4)
        assertThrows<IllegalArgumentException> {
            GameController.exception(userList)
        }
    }
}