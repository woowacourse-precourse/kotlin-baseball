package baseball

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class ComputerTest {
    private val computer=Computer()
    private val exception=Exception()
    @Test
    fun `컴퓨터 번호 생성 테스트`() {
        val number=computer.generateComputerNumber().joinToString("")
        assertDoesNotThrow { exception.throwThreeLetterException(number) }
        assertDoesNotThrow { exception.throwNonNaturalNumberException(number) }
        assertDoesNotThrow { exception.throwDuplicateNumberException(number) }
    }

}