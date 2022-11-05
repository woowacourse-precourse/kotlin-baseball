package baseball.computer

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ComputerTest {
    private val computer = Computer()

    @Test
    fun `컴퓨터가 생성한 숫자가 3자리 숫자인지 테스트`() {
       assertThat(computer.numberOfComputer.length).isEqualTo(3)
    }

    @Test
    fun `컴퓨터가 생성한 숫자에 중복이 없는지 테스트`() {
        assertThat(computer.numberOfComputer.toCharArray().toHashSet().size).isEqualTo(3)
    }
}