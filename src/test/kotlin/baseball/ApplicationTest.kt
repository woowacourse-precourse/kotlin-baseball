package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
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

    @Nested
    inner class UserInputTest {
        @Test
        fun `3자리 숫자가 아닌 값이 입력됬을 때_IllegalArgumentException을 발생시킨다`() {
            val testInputs = listOf("1234", "53", "1", "4123123123512312312312313122312312312312312312314123123", "")
            testInputs.forEach { case ->
                assertThrows<IllegalArgumentException>(
                    "$case 3자리가 아니거나, 숫자가 아닌 값"
                ) {
                    checkInputIsCorrect(case)
                }
            }
        }

        @Test
        fun `숫자가 아닌 값이 입력됬을 때_IllegalArgumentException을 발생시킨다`() {
            val testInputs = listOf("asd", "d221sf", "간12", "", " ", "@!2")
            testInputs.forEach { case ->
                assertThrows<IllegalArgumentException>(
                    "$case 3자리가 아니거나, 숫자가 아닌 값"
                ) {
                    checkInputIsCorrect(case)
                }
            }
        }

        @Test
        fun `각각 다른 3자리 숫자가 아닐 때_IllegalArgumentException을 발생시킨다`() {
            val testInputs = listOf("121", "333", "454", "666")
            testInputs.forEach { case ->
                assertThrows<IllegalArgumentException>(
                    "$case 각각 다른 3자리 숫자가 아님"
                ) {
                    checkInputIsCorrect(case)
                }
            }
        }
    }

    override fun runMain() {
        main()
    }
}
