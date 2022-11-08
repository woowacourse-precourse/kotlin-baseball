package baseball

import camp.nextstep.edu.missionutils.test.Assertions.*
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class calculateScoreTest: NsTest(){

    @Test
    fun `점수 계산 ball만 있을때`() {
        assertRandomNumberInRangeTest(
            {
                run( "351","135","2")
                Assertions.assertThat(output())
                    .contains("3볼", "3스트라이크", "게임 종료")
            },
            1, 3, 5,
        )
    }

    @Test
    fun `점수 계산 Strike 만 있을때`() {
        assertRandomNumberInRangeTest(
            {
                run( "135","2")
                Assertions.assertThat(output())
                    .contains("3스트라이크", "게임 종료")
            },
            1, 3, 5,
        )
    }

    @Test
    fun `ball 과 strike 섞여있을때`() {
        assertRandomNumberInRangeTest(
            {
                run("156", "135", "2")
                Assertions.assertThat(output())
                    .contains("1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5
        )
    }

    @Test
    fun `낫싱일때`() {
        assertRandomNumberInRangeTest(
            {
                run("987", "135", "2")
                Assertions.assertThat(output())
                    .contains("낫싱", "3스트라이크", "게임 종료")
            },
            1, 3, 5
        )
    }

    override fun runMain() {
        main()
    }
}
