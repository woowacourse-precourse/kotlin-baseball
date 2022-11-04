package baseball

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ExceptionTest {
    private val exception=Exception()

    @Test
    fun `3자리 예외 테스트`() {
        val testCase1 = listOf('1', '2', '3', '4')
        val testCase2 = listOf<Char>()
        assertThrows<IllegalArgumentException> { exception.throwThreeLetterException(testCase1) }
        assertThrows<IllegalArgumentException> { exception.throwThreeLetterException(testCase2) }
    }

    @Test
    fun `자연수 예외 테스트`() {
        val testCase1 = listOf('a', 'b', 'c')
        val testCase2 = listOf('가',']','.')
        assertThrows<IllegalArgumentException> { exception.throwNonNaturalNumberException(testCase1) }
        assertThrows<IllegalArgumentException> { exception.throwNonNaturalNumberException(testCase2) }
    }

    @Test
    fun `중복 예외 테스트`() {
        val testCase1 = listOf('1', '1', '3')
        assertThrows<IllegalArgumentException> { exception.throwDuplicateNumberException(testCase1) }
    }

    @Test
    fun `입력값 1,2 예외 테스트`() {
        val input="12"
        assertThrows<IllegalArgumentException> { exception.throwInvalidRestartNumber(input) }
    }

}