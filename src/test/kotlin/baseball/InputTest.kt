package baseball

import baseball.view.validator.InputValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest {
    @Test
    fun `사용자 입력 길이가 3이 넘어갈 때`() {
        assertThrows<IllegalArgumentException> { InputValidator.validateUserInput("1234") }
    }
}