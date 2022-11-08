package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SelfTest : NsTest() {
    @Test
    fun `랜덤 세 자릿수 숫자 생성 테스트`() {
        val computerNumber = chooseComputerNumber()
        assertThat(computerNumber).hasSize(3)
    }

    @Test
    fun `3스트라이크 테스트`() {
        val answer = "369"
        val userNumber = "369"
        val result = compareWithAnswer(answer, userNumber)
        assertThat(result.first).isEqualTo(3)
    }

    @Test
    fun `1스트라이크 1볼 테스트`() {
        val answer = "369"
        val userNumber = "397"
        val result = compareWithAnswer(answer, userNumber)
        assertThat(result.first).isEqualTo(1)
        assertThat(result.second).isEqualTo(1)
    }

    @Test
    fun `낫싱 테스트`() {
        val answer = "369"
        val userNumber = "147"
        val result = compareWithAnswer(answer, userNumber)
        assertThat(result.first).isEqualTo(0)
        assertThat(result.second).isEqualTo(0)
    }

    @Test
    fun `힌트 출력 테스트`() {
        val answer = "369"
        val userNumber = "354"
        val result = compareWithAnswer(answer, userNumber)
        printHint(result)
        assertThat(output()).contains("1스트라이크")
    }

    @Test
    fun `userNumber 예외처리 테스트`() {
        var userNumber = mutableListOf<Char>()
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validationUserNumber(userNumber, "102") }
        }
    }

    @Test
    fun `restartOrQuit 예외처리 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { validationRestartOrQuit(3) }
        }
    }

    override fun runMain() {
        main()
    }
}