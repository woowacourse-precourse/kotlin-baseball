package baseball

import baseball.game.ExceptionHandler
import baseball.game.Message
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.assertThrows

class ExceptionHandlerTest {

    private val digits = List(9) { it + 1 }

    @Nested
    @DisplayName("숫자 입력 테스트")
    inner class InputNumberFormat {

        @RepeatedTest(10)
        fun `길이3, 중복X, in (1~9)`() {
            digits.shuffled().take(3).joinToString("").let {
                assertThat(ExceptionHandler.checkNumberFormat(it)).isEqualTo(it)
            }
        }
        @Test
        fun `길이3, 중복X, not in (1~9)`() {
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("120") }
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("1x9") }
        }
        @Test
        fun `길이3, 중복O, in (1~9)`() {
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("121") }
        }
        @Test
        fun `길이3, 중복O, not in (1~9)`() {
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("101") }
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("x11") }
        }
        @Test
        fun `길이3미만, 중복X, in (1~9)`() {
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("12") }
        }
        @Test
        fun `길이3미만, 중복X, not in (1~9)`() {
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("02") }
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("1x") }
        }
        @Test
        fun `길이3미만, 중복O, in (1~9)`() {
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("11") }
        }
        @Test
        fun `길이3미만, 중복O, not in (1~9)`() {
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("11") }
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("xx") }
        }
        @Test
        fun `길이3초과, 중복X, in (1~9)`() {
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("1234") }
        }
        @Test
        fun `길이3초과, 중복X, not in (1~9)`() {
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("1230") }
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("1x34") }
        }
        @Test
        fun `길이3초과, 중복O, in (1~9)`() {
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("1232") }
        }
        @Test
        fun `길이3초과, 중복O, not in (1~9)`() {
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("1202") }
            throwIllegalArgumentException { ExceptionHandler.checkNumberFormat("121x") }
        }
    }

    private fun throwIllegalArgumentException(executable: () -> Unit) {
        assertSimpleTest { assertThrows<IllegalArgumentException>(executable) }
    }
}