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
    fun `랜덤 값 길이 검사`() {
        val randomNumber = getComputerNumber()
        assertThat(randomNumber).hasSize(3)
    }

    @Test
    fun `유저 입력값 정상 인식 검사`() {
        System.setIn("123".byteInputStream())
        val userNumber = getUserPredictionNumber()
        assertThat(userNumber).isEqualTo("123")
    }

    @Test
    fun `유저 입력값 및 랜덤 값 비교 정답인 경우`() {
        val correct = isUserAnswerWrong("123", "123")
        assertThat(correct).isEqualTo(false)
        output().contains("3스트라이크")
        output().contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        output().contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }

    @Test
    fun `유저 입력값 및 랜덤 값 비교 오답 1`() {
        val incorrect = isUserAnswerWrong("123", "456")
        assertThat(incorrect).isEqualTo(true)
        output().contains("낫싱")
    }

    @Test
    fun `유저 입력값 및 랜덤 값 비교 오답 2`() {
        val incorrect = isUserAnswerWrong("123", "554")
        assertThat(incorrect).isEqualTo(true)
        assertThat(output()).contains("낫싱")
    }

    @Test
    fun `유저 입력값 및 랜덤 값 비교 오답 3`() {
        val incorrect = isUserAnswerWrong("123", "154")
        assertThat(incorrect).isEqualTo(true)
        assertThat(output()).contains("1스트라이크")
    }

    @Test
    fun `유저 입력값 및 랜덤 값 비교 오답 4`() {
        val incorrect = isUserAnswerWrong("123", "354")
        assertThat(incorrect).isEqualTo(true)
        assertThat(output()).contains("1볼")
    }

    @Test
    fun `유저 입력값 및 랜덤 값 비교 오답 5`() {
        val incorrect = isUserAnswerWrong("123", "913")
        assertThat(incorrect).isEqualTo(true)
        assertThat(output()).contains("1볼 1스트라이크")
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
