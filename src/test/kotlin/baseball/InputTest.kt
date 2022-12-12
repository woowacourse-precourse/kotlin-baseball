package baseball

import baseball.util.Validator.check3digitNum
import baseball.util.Validator.checkCommand
import baseball.view.InputView
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class InputTest {

    @ValueSource(strings = ["a", " ", "123d"])
    @ParameterizedTest
    fun `플레이어가 숫자 형태로 입력하지 않으면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            check3digitNum(input)
        }
    }

    @ValueSource(strings = ["012", "01234"])
    @ParameterizedTest
    fun `플레이어가 1~9 사이 숫자를 입력하지 않으면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            check3digitNum(input)
        }
    }

    @ValueSource(strings = ["112", "223"])
    @ParameterizedTest
    fun `플레이어가 중복된 숫자를 입력하면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            check3digitNum(input)
        }
    }

    @ValueSource(strings = ["012", "009"])
    @ParameterizedTest
    fun `플레이어가 1~9사이 숫자를 입력하지 않으면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            check3digitNum(input)
        }
    }

    @ValueSource(strings = ["0", "a", "12"])
    @ParameterizedTest
    fun `플레이어가 1또는 2를 입력하지 않으면 예외 발생`(input: String) {
        assertThrows<IllegalArgumentException> {
            checkCommand(input)
        }
    }
}