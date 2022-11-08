package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class ComputerTest {
    @Test
    fun `랜덤 생성 숫자 자리수 확인`() {
        assertThat(answer.size).isEqualTo(3)
    }

    @Test
    fun `서로 다른 숫자 3개인지 확인`() {
        assertThat(answer.distinct().size).isEqualTo(3)
    }

    companion object {
        lateinit var computer: Computer
        lateinit var answer: ArrayList<Int>

        @BeforeAll
        @JvmStatic
        internal fun init() {
            computer = Computer()
            computer.generateAnswer()
            answer = computer.testGetAnswer()
        }
    }
}