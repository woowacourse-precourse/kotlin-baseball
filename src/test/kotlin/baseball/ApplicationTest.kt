package baseball

import baseball.gameservice.BallStrikeCounter
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
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
            assertThrows<IllegalArgumentException> {
                runException("1234")
            }
        }
    }

    @Test
    fun `사용자의 입력이 숫자가 아닌 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            runException("우테코 합격기원")
        }
    }

    @Test
    fun `사용자의 입력에 0이 포함된 숫자가 있는 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            runException("103")
        }
    }

    @Test
    fun `사용자의 입력에 중복된 숫자가 있는 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            runException("113")
        }
    }

    @Test
    fun `사용자의 입력이 세자리가 아닌 경우 예외 발생`() {
        assertThrows<IllegalArgumentException> {
            runException("7777")
        }
    }

    @Test
    fun `컴퓨터가 발생시킨 임의의 숫자 리스트 크기가 3인지 확인`() {
        assertThat(Computer().randomNumbers.size).isEqualTo(3)
    }

    @Test
    fun `스트라이크된 숫자의 개수가 하나인 경우`() {
        assertThat(BallStrikeCounter.calcStrikeCount(arrayListOf(3, 5, 4), arrayListOf(4, 5, 1))).isEqualTo(1)
    }

    @Test
    fun `스트라이크된 숫자의 개수가 두개인 경우`() {
        assertThat(BallStrikeCounter.calcStrikeCount(arrayListOf(1, 5, 4), arrayListOf(1, 2, 4))).isEqualTo(2)
    }

    @Test
    fun `스트라이크된 숫자의 개수가 세개인 경우`() {
        assertThat(BallStrikeCounter.calcStrikeCount(arrayListOf(1, 5, 4), arrayListOf(1, 5, 4))).isEqualTo(3)
    }

    @Test
    fun `볼이된 숫자의 개수가 하나인 경우`() {
        assertThat(BallStrikeCounter.calcBallCount(arrayListOf(3, 5, 4), arrayListOf(4, 5, 1))).isEqualTo(1)
    }

    @Test
    fun `볼이된 숫자의 개수가 두개인 경우`() {
        assertThat(BallStrikeCounter.calcBallCount(arrayListOf(1, 5, 4), arrayListOf(4, 2, 1))).isEqualTo(2)
    }

    @Test
    fun `볼이된 숫자의 개수가 세개인 경우`() {
        assertThat(BallStrikeCounter.calcBallCount(arrayListOf(4, 5, 1), arrayListOf(5, 1, 4))).isEqualTo(3)
    }

    override fun runMain() {
        main()
    }
}
