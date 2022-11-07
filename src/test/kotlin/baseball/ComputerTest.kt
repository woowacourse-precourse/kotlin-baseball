package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ComputerTest {

    @Test
    fun `Computer클래스의 input()이 제대로 숫자 세 개 가져오는지 확인`() {
        val computer = Computer()
        val computerInput = computer.input() as List<Int>
        var isBoolean = true
        computerInput.forEach { if (it < 0 || it > 10) isBoolean = false }
        if (computerInput.size != 3) {
            isBoolean = false
        }
        assertThat(isBoolean).isEqualTo(true)
    }
}