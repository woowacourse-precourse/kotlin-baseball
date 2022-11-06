package baseball

import org.assertj.core.api.Assertions.assertThat
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

    @Test
    fun `스트라이크 카운트 1 확인`() {
        val computer = listOf(1, 2, 3)
        val user = listOf(1, 3, 2)
        val strike = GameController.getStrikeCount(computer, user)
        assertThat(strike).isEqualTo(1)
    }

    @Test
    fun `스트라이크 카운트 2 확인`() {
        val computer = listOf(1, 2, 3)
        val user = listOf(1, 2, 4)
        val strike = GameController.getStrikeCount(computer, user)
        assertThat(strike).isEqualTo(2)
    }

    @Test
    fun `스트라이크 카운트 3 확인`() {
        val computer = listOf(1, 2, 3)
        val user = listOf(1, 2, 3)
        val strike = GameController.getStrikeCount(computer, user)
        assertThat(strike).isEqualTo(3)
    }

    @Test
    fun `볼 카운트 1 확인`() {
        val computer = listOf(1, 2, 3)
        val user = listOf(1, 3, 4)
        val ball = GameController.getBallCount(computer, user)
        assertThat(ball).isEqualTo(1)
    }

    @Test
    fun `볼 카운트 2 확인`() {
        val computer = listOf(1, 2, 3)
        val user = listOf(3, 1, 4)
        val ball = GameController.getBallCount(computer, user)
        assertThat(ball).isEqualTo(2)
    }

    @Test
    fun `볼 카운트 3 확인`() {
        val computer = listOf(1, 2, 3)
        val user = listOf(3, 1, 2)
        val ball = GameController.getBallCount(computer, user)
        assertThat(ball).isEqualTo(3)
    }
}