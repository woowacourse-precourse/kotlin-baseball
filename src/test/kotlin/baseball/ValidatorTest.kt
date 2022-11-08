package baseball

import baseball.utils.Validator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidatorTest {

    private val validator = Validator

    @Test
    fun `정답 숫자 입력값의 길이가 3이 아니라면, false를 반환한다`() {
        inputNotSizeThreeList.forEach { input ->
            assertThat(validator.isValidAnswerNumber(input)).isEqualTo(false)
        }
    }

    @Test
    fun `정답 숫자 입력값에 문자가 포함되어 있으면, false를 반환한다`() {
        val input = "가12h"
        assertThat(validator.isValidAnswerNumber(input)).isEqualTo(false)
    }

    @Test
    fun `정답 숫자 입력값에 중복되는 문자가 있으면, false를 반환한다`() {
        val input = "866"
        assertThat(validator.isValidAnswerNumber(input)).isEqualTo(false)
    }

    @Test
    fun `종료 코드 입력값의 길이가 1이 아니라면, false를 반환한다`() {
        inputNotSizeOneList.forEach { input ->
            assertThat(validator.isValidExitCode(input)).isEqualTo(false)
        }
    }

    @Test
    fun `종료 코드 입력값의 문자가 "1"과 "2"가 아니라면, false를 반환한다`() {
        exceptionExitCodeList.forEach { input ->
            assertThat(validator.isValidExitCode(input)).isEqualTo(false)
        }
    }

    companion object {
        private val inputNotSizeThreeList = listOf<String>(
            "1235",
            "",
            "1"
        )
        private val inputNotSizeOneList = listOf<String>(
            "3456",
            "",
            "31"
        )
        private val exceptionExitCodeList = listOf<String>(
            "8",
            "0",
            "h",
            "가"
        )
    }

}