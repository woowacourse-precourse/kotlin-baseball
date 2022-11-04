package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserTest {
    private val user = User()

    @Test
    fun `String을 Int 리스트로 바꿔서 유저의 숫자를 저장`() {
        val userNumber = user.getUserNumber("123")
        assertThat(userNumber).isEqualTo(listOf(1, 2, 3))
    }
}
