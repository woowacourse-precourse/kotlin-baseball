package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `생성된 숫자가 1부터 9사이의 중복없는 3자리 숫자인지 검사`() {
        val digits = generateRandomThreeDigits()
        assertThat(digits)
            .hasSize(3)
            .allMatch { it in 1..9 }
            .isEqualTo(digits.distinct())
    }

    @Test
    fun `사용자 입력이 1부터 9사이의 중복없는 3자리 숫자인지 검사`() {
        val inputs = listOf("246", "135", "1", "597", "589", "2", "024", "201")
        val expects = listOf(true, true, false, true, true, false, false, false)

        for (idx in inputs.indices) {
            val validationResult = validateUserInput(inputs[idx])
            assertThat(validationResult)
                .isEqualTo(expects[idx])
        }
    }

    @Test
    fun `게임종료 후 재시작`() {
        assertRandomNumberInRangeTest(
            {
                run("246", "135", "1", "597", "589", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    override fun runMain() {
        main()
    }
}
