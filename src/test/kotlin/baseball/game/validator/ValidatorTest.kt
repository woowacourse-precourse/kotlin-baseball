package baseball.game.validator

import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {
    private val inputValidator = InputValidator()

    @Test
    fun `게임 입력이 3자리 수가 아니면 예외 발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputValidator.validateGameInput("1234") }
        }
    }

    @Test
    fun `게임 입력 안에 숫자 0이 존재하면 예외 발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputValidator.validateGameInput("120") }
        }
    }

    @Test
    fun `게임 입력 안에 숫자 중복이 있으면 예외 발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputValidator.validateGameInput("131") }
        }
    }

    @Test
    fun `게임 입력 안에 숫자가 아닌 문자가 있으면 예외 발생`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputValidator.validateGameInput("12c") }
        }
    }
}