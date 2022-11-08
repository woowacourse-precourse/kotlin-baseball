package baseball

import baseball.domain.ComputerNumbers
import baseball.view.InputView
import baseball.view.OutputView
import camp.nextstep.edu.missionutils.test.Assertions.*
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Assertions
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
    fun `입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시`() {
        assertRandomNumberInRangeTest(
            {
                run("145", "415","135","123", "2")
              assertThat(output())
                    .contains("1스트라이크", "1볼", "1볼 1스트라이크","3스트라이크", "게임 종료")
            },
            1, 2, 3
        )
    }

    @Test
    fun `하나도 없는 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("987", "123", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "게임 종료")
            },
            1, 2, 3
        )
    }

    @Test
    fun `3개의 숫자를 모두 맞힐 경우`() {
        assertRandomNumberInRangeTest(
            {
                run( "135","2")
                assertThat(output())
                    .contains("3스트라이크", "게임 종료")
            },
            1, 2, 3,
        )
    }


    override fun runMain() {
        main()
    }
}
