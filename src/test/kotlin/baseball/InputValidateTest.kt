package baseball

import baseball.view.validate.InputValidate
import org.junit.jupiter.api.BeforeEach
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
    @ValueSource(strings = ["", "1234", "23"])
    fun `입력한 숫자가 3자리수가 아닐 경우 예외 발생 `(input: String) {
        assertThrows<IllegalArgumentException>() {
            inputValidate.baseballNumbersForm(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["021", "a34", "^a3"])
    fun `입력한 숫자가 각각 1 부터 9까지가 아닐 경우 예외 발생 `(input: String) {
        assertThrows<IllegalArgumentException>() {
            inputValidate.baseballNumbersForm(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["133", "911", "777"])
    fun `입력한 숫자의 중복값이 있을 경우 예외 발생 `(input: String) {
        assertThrows<IllegalArgumentException>() {
            inputValidate.duplicateBaseballNumbers(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["5", "ㅁ", "!"])
    fun `입력한 숫자가 1 또는 2가 아닐시 예외 발생 `(input: String) {
        assertThrows<IllegalArgumentException>() {
            inputValidate.restartNumber(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["12", "123", "21"])
    fun `입력한 숫자가 한개가 아닐시 예외 발생 `(input: String) {
        assertThrows<IllegalArgumentException>() {
            inputValidate.restartNumber(input)
        }
    }

}