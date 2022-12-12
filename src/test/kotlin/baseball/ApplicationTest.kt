package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import domain.Computer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import view.OutputView

class ApplicationTest : NsTest() {
    @Nested
    inner class CheckBallStrikeCount(){
        @Test
        fun case1(){
            val result = Computer().compareList(listOf(1,2,3), listOf(1,2,3))
            assertThat(result).isEqualTo(Pair(3,0))
        }
        @Test
        fun case2(){
            val result = Computer().compareList(listOf(1,2,3), listOf(1,3,2))
            assertThat(result).isEqualTo(Pair(1,2))
        }

    }

    @Nested
    inner class CheckPrintBaseballCount(){
        @Test
        fun `게임 검사 결과 1`(){
            OutputView().showBaseballMessage(Pair(1,2))
            assertThat(output()).isEqualTo("2볼 1스트라이크")
        }
        @Test
        fun `게임 검사 결과 2`(){
            OutputView().showBaseballMessage(Pair(3,0))
            assertThat(output()).contains("3스트라이크")
        }
        @Test
        fun `게임 검사 결과3`(){
            OutputView().showBaseballMessage(Pair(1,1))
            assertThat(output()).contains("1볼 1스트라이크")
        }

    }

    override fun runMain() {
        main()
    }
}
