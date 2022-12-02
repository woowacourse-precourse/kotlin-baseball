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
    @ValueSource(ints = [10, -3, 123])
    fun `입력값이 1 부터 9까지 숫자인지 테스트 `(number: Int) {
        assertThrows<IllegalArgumentException>() {
            InputValidate.numbersRange(number)
        }
    }
}