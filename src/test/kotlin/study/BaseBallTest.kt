package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName

import org.junit.jupiter.api.Test

class BaseBallTest {
    @Test
    fun `랜덤숫자 3개를 잘 생성하는지 테스트`(){
        val result = baseball.makeNumber()
        assertThat(result.size).isEqualTo(3)
    }
}