package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ComputerTest {

    @Test
    fun `입력값 점수 환산 테스트`() {
        var computer = Computer
        computer.correctNumber.clear()
        computer.correctNumber.addAll(mutableListOf(1, 3, 5))
        println(computer.correctNumber)
        computer.compareInputWithCorrectNumber("135")
        assertThat(computer.strike).isEqualTo(3)
    }
}