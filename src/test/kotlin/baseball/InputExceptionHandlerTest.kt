package baseball

import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class InputExceptionHandlerTest{
    private val inputExceptionHandler = InputExceptionHandler

    @ParameterizedTest
    @CsvSource(INPUT_NUMBER_IS_LONGER, INPUT_NUMBER_IS_DIGIT, INPUT_NUMBER_IS_DISTINCT)
    fun `야구 게임 입력 숫자 테스트`(inputNumber: String) {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                inputExceptionHandler.checkInputNumber(inputNumber)
            }
        }
    }

    @ParameterizedTest
    @CsvSource(STATUS_NUMBER_IS_CORRECT, STATUS_NUMBER_IS_LONGER, STATUS_NUMBER_IS_DIGIT)
    fun `재시작 or 종료 입력 숫자 테스트`(inputStatusNumber: String) {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                inputExceptionHandler.checkInputStatusNumber(inputStatusNumber)
            }
        }
    }

    companion object {
        const val INPUT_NUMBER_IS_LONGER = "1234"
        const val INPUT_NUMBER_IS_DIGIT = "a12"
        const val INPUT_NUMBER_IS_DISTINCT = "113"

        const val STATUS_NUMBER_IS_LONGER = "12"
        const val STATUS_NUMBER_IS_DIGIT = "a"
        const val STATUS_NUMBER_IS_CORRECT = "3"
    }
}