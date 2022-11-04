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
    fun `게임 시작 문구 출력 테스트`() {
        run()
        assertThat(output()).contains("숫자 야구 게임을 시작합니다.")
    }

    override fun runMain() {
        main()
    }
}
