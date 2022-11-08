package baseball

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BaseballResultTest {
    @Test
    fun `오버라이드한 toString 메서드로 BaseballResult 객체 출력 시 요구하는 출력 형태로 출력`() {
        val inputList = listOf(
            BaseballResult(1,1),
            BaseballResult(0, 3),
            BaseballResult(1, 0),
            BaseballResult(0, 0)
        )
        val result = inputList.map { input ->
            input.toString()
        }
        assertThat(result)
            .contains("1볼 1스트라이크", "3스트라이크", "1볼", "낫싱")
    }

    @Test
    fun `연산자 오버로딩한 plus 메서드로 주어진 값을 더함`() {
        val input = BaseballResult(1,0)
        val result = BaseballResult(0, 1)
        result.plus(input)
        assertThat(result).isEqualTo(BaseballResult(1, 1))
    }
}