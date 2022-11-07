package model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class UserTest {
    private val user = User()

    @Test
    fun `사용자 입력을 리스트로 반환`() {
        user.inputConvertToList("1234")
        assertThat(user.numberList).isEqualTo(listOf(1, 2, 3, 4))
    }

}