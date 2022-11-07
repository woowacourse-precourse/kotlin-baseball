package baseball

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FunctionTest : NsTest() {
    @Test
    fun `Integer Type 이외의 값 입력`() {
        assertThrows<IllegalArgumentException> {
            val inputString = "3글자"
            System.setIn(inputString.byteInputStream())
            validateInputString(inputString, isNewGameCheckInputString = false)
        }
        assertThrows<IllegalArgumentException> {
            val inputString = "303.1"
            System.setIn(inputString.byteInputStream())
            validateInputString(inputString, isNewGameCheckInputString = false)
        }
        assertThrows<IllegalArgumentException> {
            val inputString = "3글자"
            System.setIn(inputString.byteInputStream())
            validateInputString(inputString, isNewGameCheckInputString = true)
        }
        assertThrows<IllegalArgumentException> {
            val inputString = "303.1"
            System.setIn(inputString.byteInputStream())
            validateInputString(inputString, isNewGameCheckInputString = true)
        }
    }

    @Test
    fun `0이 들어간 값 입력`() {
        assertThrows<IllegalArgumentException> {
            val inputString = "203"
            System.setIn(inputString.byteInputStream())
            validateInputString(inputString, isNewGameCheckInputString = false)
        }
    }

    @Test
    fun `길이가 3이 아닌 값 입력`() {
        assertThrows<IllegalArgumentException> {
            val inputString = "1"
            System.setIn(inputString.byteInputStream())
            validateInputString(inputString, isNewGameCheckInputString = false)
        }
        assertThrows<IllegalArgumentException> {
            val inputString = "1234"
            System.setIn(inputString.byteInputStream())
            validateInputString(inputString, isNewGameCheckInputString = false)
        }
    }

    @Test
    fun `중복된 숫자가 존재하는 값 입력`() {
        assertThrows<IllegalArgumentException> {
            val inputString = "144"
            System.setIn(inputString.byteInputStream())
            validateInputString(inputString, isNewGameCheckInputString = false)
        }
    }

    @Test
    fun `게임 재시작 값 입력`() {
        assertThrows<IllegalArgumentException> {
            val inputString = "3"
            System.setIn(inputString.byteInputStream())
            validateInputString(inputString, isNewGameCheckInputString = true)
        }
        assertThrows<IllegalArgumentException> {
            val inputString = "0"
            System.setIn(inputString.byteInputStream())
            validateInputString(inputString, isNewGameCheckInputString = true)
        }
    }

    @Test
    fun `유저 입력값 정상 인식 검사`() {
        System.setIn("123".byteInputStream())
        val userNumber = getUserPredictionNumber()
        assertThat(userNumber).isEqualTo("123")
    }

    @Test
    fun `정답 맞춘 후 재시작`() {
        System.setIn("1".byteInputStream())
        val quitCode = isContinuedNewGame()
        assertThat(quitCode).isEqualTo(true)
    }

    @Test
    fun `정답 맞춘 후 종료`() {
        System.setIn("2".byteInputStream())
        val quitCode = isContinuedNewGame()
        assertThat(quitCode).isEqualTo(false)
    }

    override fun runMain() {
        main()
    }
}
