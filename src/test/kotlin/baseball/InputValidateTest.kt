package baseball

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.IllegalArgumentException

class InputValidateTest {
    private lateinit var inputValidate: InputValidate

    @BeforeEach
    fun setup() {
        inputValidate = InputValidate()
    }
    @ParameterizedTest
    @ValueSource(strings = ["", "1234","23"])
    fun `입력한 숫자가 3자리수가 아닐 경우 예외 발생 `(numbers: String) {
        assertThrows<IllegalArgumentException>() {
            inputValidate.baseballNumbersForm(numbers)
        }
    }
    @ParameterizedTest
    @ValueSource(strings = ["021", "a34","^a3"])
    fun `입력한 숫자가 각각 1 부터 9까지가 아닐 경우 예외 발생 `(numbers: String) {
        assertThrows<IllegalArgumentException>() {
            inputValidate.baseballNumbersForm(numbers)
        }
    }
}