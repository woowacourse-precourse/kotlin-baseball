package baseball

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class MyTest {
    @Test
    fun `각각 다른 숫자인지 확인`() {
        val input = "345"
        Assertions.assertThat(checkSameNumber(input)).isEqualTo(false)
    }

    @Test
    fun `같은 숫자가 있는지 확인`() {
        val input = "334"
        Assertions.assertThat(checkSameNumber(input)).isEqualTo(true)
    }
}