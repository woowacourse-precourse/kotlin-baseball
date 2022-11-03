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
    inner class PrinterTest {
        @Test
        fun `게임 시작 메시지 출력 테스트`() {
            Printer().showStartMessage()
            val result = ("숫자 야구 게임을 시작합니다.")
            assertThat(output()).isEqualTo(result)
        }

        @Test
        fun `숫자 입력 메시지 출력 테스트`() {
            Printer().showInputMessage()
            val result = ("숫자를 입력해주세요 : ")
            assertThat(output()).isEqualTo(result)
        }

        @Test
        fun `스트라이크 메시지 출력`() {
            Printer().showStrikeMessage(3)
            val result = ("3스트라이크")
            assertThat(output()).isEqualTo(result)
        }

        @Test
        fun `볼 메시지 출력`() {
            Printer().showBallMessage(3)
            val result = ("3볼")
            assertThat(output()).isEqualTo(result)
        }

        @Test
        fun `낫싱 메시지 출력`() {
            Printer().showNothingMessage()
            val result = ("낫싱")
            assertThat(output()).isEqualTo(result)
        }

        @Test
        fun `볼&스트라이크 메시지 출력`() {
            Printer().showBallStrikeMessage(1, 1)
            val result = ("1볼 1스트라이크")
            assertThat(output()).isEqualTo(result)
        }

        @Test
        fun `게임종료&다시시작 메시지 출력`() {
            Printer().showEndMessage()
            val result = ("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            assertThat(output()).isEqualTo(result)
        }
    }

    override fun runMain() {
        main()
    }
}
