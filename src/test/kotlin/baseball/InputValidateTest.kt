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
        val inputValidate: InputValidate()
    }
}