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
            1,
            3,
            5,
            5,
            8,
            9
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
        fun `심판 판정 결과 출력`() {
            Printer().showCountingMessage(0, 0)
            val result = "낫싱"
            assertThat(output()).isEqualTo(result)
        }

        @Test
        fun `게임종료&다시시작 메시지 출력`() {
            Printer().showEndMessage()
            val result = ("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            assertThat(output()).isEqualTo(result)
        }
    }

    @Nested
    inner class ComputerTest {
        private val computer = Computer()

        @Test
        fun `컴퓨터 난수 생성 - 3자리수 검사`() {
            computer.createComputerNumbers()
            assertThat(computer.computerNumbers).hasSize(3)
        }

        @Test
        fun `컴퓨터 난수 생성 - 1~9범위 검사`() {
            computer.createComputerNumbers()
            println(computer.computerNumbers)
            computer.computerNumbers.forEach() {
                assertThat(it).isIn(1..9)
            }
        }

        @Test
        fun `컴퓨터 난수 생성 - 중복 검사`() {
            computer.createComputerNumbers()
            println(computer.computerNumbers)
            assertThat(computer.computerNumbers).doesNotHaveDuplicates()
        }
    }

    @Nested
    inner class UserTest {
        private val user = User()

        @Test
        fun `유저 입력 - 3자리수 검사`() {
            user.enterUserNumbers("1234")
            assertThat(user.userNumbers).hasSize(3)
        }

        @Test
        fun `유저 입력 - 1~9범위 검사`() {
            user.enterUserNumbers("430")
            user.userNumbers.forEach() {
                assertThat(it).isIn(1..9)
            }
        }

        @Test
        fun `유저 입력 - 중복 검사`() {
            user.enterUserNumbers("335")
            assertThat(user.userNumbers).doesNotHaveDuplicates()
        }
    }

    @Nested
    inner class RefereeTest {
        private val referee = Referee()
        private val user = User()

        @Test
        fun `심판 - 판정 검사`() {
            val computerNumbers = listOf<Int>(1, 3, 8)
            user.enterUserNumbers("123")
            val refereeDecision = referee.decideGameEnd(computerNumbers, user.userNumbers)
            assertThat(refereeDecision).isEqualTo(RefereeDecision(1, 1, false))
        }
    }

    override fun runMain() {
        main()
    }
}
