package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `랜덤 세 자리 숫자 생성`() {
        val randomNumber = randomThreeNumber()
        assertThat(randomNumber).hasSize(3)
    }

    @Test
    fun `두 자리 입력 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputErrorCheck("12") }
        }
    }

    @Test
    fun `네 자리 입력 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputErrorCheck("1234") }
        }
    }

    @Test
    fun `중복된 숫자 입력 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputErrorCheck("366") }
        }
    }

    @Test
    fun `0 입력 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputErrorCheck("012") }
        }
    }

    @Test
    fun `문자 입력 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputErrorCheck("Ab1") }
        }
    }

    @Test
    fun `1이나 2가 아닌 숫자 입력 시 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputErrorCheckOneNum("0") }
        }
    }

    @Test
    fun `1이나 2가 아닌 문자를 입력 시 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { inputErrorCheckOneNum("a") }
        }
    }

    @Test
    fun `스트라이크 0개 찾기`() {
        val computer = listOf<Int>(1, 4, 8)
        val user = listOf<Int>(9, 8, 4)
        val result = findStrike(computer, user)
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `스트라이크 1개 찾기`() {
        val computer = listOf<Int>(1, 8, 3)
        val user = listOf<Int>(2, 8, 9)
        val result = findStrike(computer, user)
        assertThat(result).isEqualTo(1)
    }

    @Test
    fun `스트라이크 2개 찾기`() {
        val computer = listOf<Int>(1, 2, 3)
        val user = listOf<Int>(4, 2, 3)
        val result = findStrike(computer, user)
        assertThat(result).isEqualTo(2)
    }

    @Test
    fun `스트라이크 3개 찾기`() {
        val computer = listOf<Int>(5, 6, 9)
        val user = listOf<Int>(5, 6, 9)
        val result = findStrike(computer, user)
        assertThat(result).isEqualTo(3)
    }

    @Test
    fun `볼 0개 찾기`() {
        val computer = listOf<Int>(1, 3, 5)
        val user = listOf<Int>(2, 4, 6)
        val result = findBall(computer, user)
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun `볼 3개 찾기`() {
        val computer = listOf<Int>(4, 5, 6)
        val user = listOf<Int>(6, 4, 5)
        val result = findBall(computer, user)
        assertThat(result).isEqualTo(3)
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
    fun `게임종료 후 재시작 2`() {
        assertRandomNumberInRangeTest(
                {
                    run("123", "572", "1", "125", "123", "2")
                    assertThat(output())
                            .contains("1볼", "3스트라이크", "2스트라이크", "3스트라이크", "게임 종료")
                },
                5, 7, 2, 1, 2, 3
        )
    }

    @Test
    fun `게임종료 후 재시작 3`() {
        assertRandomNumberInRangeTest(
                {
                    run("431", "987", "942", "2")
                    assertThat(output())
                            .contains("1볼", "1스트라이크", "3스트라이크", "게임 종료")
                },
                9, 4, 2
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
