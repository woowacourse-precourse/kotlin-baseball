package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
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
        val inputs = listOf("246", "135", "1", "597", "589", "2", "024", "201", "안녕", "hi", "")
        val expects = listOf(true, true, false, true, true, false, false, false, false, false, false)

        for (idx in inputs.indices) {
            try {
                validatePlayInput(inputs[idx])
            } catch (e: IllegalArgumentException) {
                assertThat(expects[idx]).isFalse
            }
        }
    }

    @Test
    fun `게임 종료 여부 판단 사용자 입력이 1 혹은 2 인지 검사`() {
        val inputs = listOf("246", "135", "1", "597", "589", "2", "024", "201", "안녕", "hi", "")
        val expects = listOf(false, false, true, false, false, true, false, false, false, false, false)

        for (idx in inputs.indices) {
            try {
                validateEndInput(inputs[idx])
            } catch (e: IllegalArgumentException) {
                assertThat(expects[idx]).isFalse
            }
        }
    }

    @Test
    fun `사용자 입력 숫자 각 자릿수 분리`() {
        val inputs = listOf("246", "135", "597", "589")
        val expects = listOf(
            listOf(2, 4, 6),
            listOf(1, 3, 5),
            listOf(5, 9, 7),
            listOf(5, 8, 9))

        for (idx in inputs.indices) {
            val digits = splitUserInput(inputs[idx])
            assertThat(digits)
                .isEqualTo(expects[idx])
        }
    }

    @Test
    fun `숫자 비교 결과`() {
        val computer = listOf(7, 1, 3)
        val users = listOf(
            listOf(1, 2, 3),
            listOf(1, 4, 5),
            listOf(6, 7, 1),
            listOf(2, 1, 6),
            listOf(7, 1, 3))
        val expects = listOf(
            "1볼 1스트라이크\n",
            "1볼\n",
            "2볼\n",
            "1스트라이크\n",
            "3스트라이크\n")

        for (idx in users.indices) {
            val result = CompResult(computer, users[idx])
            assertThat(result.toString())
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
