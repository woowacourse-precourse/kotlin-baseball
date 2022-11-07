package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
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
            assertThrows<IllegalArgumentException> { runException("abc") }
            assertThrows<IllegalArgumentException> { runException("112") }
        }
    }

    @Test
    fun `컴퓨터 숫자 테스트`() {
        val computerNumber = generateComputerNumber()
        val computerNumberTest = fun(): Boolean {
            // 컴퓨터 숫자 크기 테스트
            if (computerNumber.size != 3) return false

            // 컴퓨터 숫자 범위 테스트
            computerNumber.forEach { i ->
                if (i !in 1..9) {
                    return false
                }
            }

            // 컴퓨터 숫자 중복 테스트
            if (computerNumber.distinct() != computerNumber) return false

            return true
        }

        assertTrue(computerNumberTest)
    }

    @Test
    fun `숫자 비교 결과 테스트`() {
        val computerNumber = listOf<Int>(1, 2, 3)
        val userNumber = listOf<Int>(1, 3, 4)
        val result = listOf<Int>(1, 1)
        assertThat(compareNumber(computerNumber, userNumber)).isEqualTo(result)
    }

    override fun runMain() {
        main()
    }
}
