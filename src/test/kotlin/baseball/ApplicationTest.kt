package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
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
    fun `포맷팅 테스트`() {
        val oneBallTwoStrike = "1볼 2스트라이크"
        val fourBall = "4볼"
        val threeStrike = "3스트라이크"
        val noBallNoResult = "낫싱"

        assertThat(makeFormattedResult(1, 2)).isEqualTo(oneBallTwoStrike)
        assertThat(makeFormattedResult(4, 0)).isEqualTo(fourBall)
        assertThat(makeFormattedResult(0, 3)).isEqualTo(threeStrike)
        assertThat(makeFormattedResult(0, 0)).isEqualTo(noBallNoResult)
    }

    @Test
    fun `스트라이크 테스트`() {
        assertThat(findStrikeScore("123", "124")).isEqualTo(2)
        assertThat(findStrikeScore("123", "123")).isEqualTo(3)
        assertThat(findStrikeScore("123", "456")).isEqualTo(0)
    }

    @Test
    fun `볼 테스트`() {
        assertThat(findBallScore("123", "321")).isEqualTo(2)
        assertThat(findBallScore("123", "123")).isEqualTo(0)
        assertThat(findBallScore("123", "356")).isEqualTo(1)
    }

    @Test
    fun `랜덤 값 생성 테스트`() {
        val funResult = generateRandomNumber()
        assertThat(funResult.length == 3 && funResult.toSet().size == 3).isEqualTo(true)
    }

    @Test
    fun `인풋 값 체크 테스트`() {
        assertThrows<IllegalArgumentException> {
            checkInputNumberValid("12")
        }
        assertDoesNotThrow {
            checkInputNumberValid("345")
        }
        assertThrows<IllegalArgumentException> {
            checkInputNumberValid("6789")
        }
    }

    @Test
    fun `엔딩 값 체크 테스트`() {
        assertDoesNotThrow {
            checkEndingNumberValid("1")
        }
        assertDoesNotThrow {
            checkEndingNumberValid("2")
        }
        assertThrows<IllegalArgumentException> {
            checkEndingNumberValid("3")
        }
    }

    override fun runMain() {
        main()
    }
}
