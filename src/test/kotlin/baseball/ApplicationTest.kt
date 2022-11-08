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
                assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            }, 1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `게임 시작 메시지 출력 테스트`() {
        printGameStartText()
        val result = "숫자 야구 게임을 시작합니다."
        assertThat(output()).isEqualTo(result)
    }

    @Nested
    inner class ComputerTest {
        private val computerNumberList = mutableListOf<Int>()

        @Test
        fun `컴퓨터 난수로 생성된 숫자 개수 및 중복 테스트`() {
            inputComputerNumbers(computerNumberList)
            assertThat(computerNumberList.size).isEqualTo(3)
            assertThat(computerNumberList.size).isEqualTo(computerNumberList.toSet().size)
        }
    }

    @Nested
    inner class UserTest {
        @Test
        fun `유저가 입력한 숫자의 길이 테스트`() {
            val result = inputUserNumberExceptionCheck(mutableListOf(3, 2, 1))
            assertThat(result).isEqualTo(false)
        }

        @Test
        fun `유저가 입력한 숫자 중복 테스트`() {
            val result = inputUserNumberExceptionCheck(mutableListOf(3, 2, 2))
            assertThat(result).isEqualTo(true)
        }
    }

    @Nested
    inner class GameTest {
        private val computerNumbers = mutableListOf<Int>(1, 2, 3)
        val test1 = mutableListOf(4, 5, 6)
        val test2 = mutableListOf(3, 7, 8)
        val test3 = mutableListOf(7, 8, 3)
        val test4 = mutableListOf(1, 5, 3)
        val test5 = mutableListOf(1, 2, 3)

        @Test
        fun `게임 종료 검사`() {
            assertThat(checkUserNumbers(test1, computerNumbers)).isEqualTo(false)
            assertThat(checkUserNumbers(test2, computerNumbers)).isEqualTo(false)
            assertThat(checkUserNumbers(test3, computerNumbers)).isEqualTo(false)
            assertThat(checkUserNumbers(test4, computerNumbers)).isEqualTo(false)
            assertThat(checkUserNumbers(test5, computerNumbers)).isEqualTo(true)
        }

        @Test
        fun `게임 결과 검사`() {
            printUserCount(3, 0)
            assertThat(output()).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료")

//            printUserCount(1, 0)
//            assertThat(output()).isEqualTo("1스트라이크")
//
//            printUserCount(0, 1)
//            assertThat(output()).isEqualTo("1볼")
//
//            printUserCount(0, 0)
//            assertThat(output()).isEqualTo("낫싱")
//
//            printUserCount(1, 1)
//            assertThat(output()).isEqualTo("1볼 1스트라이크")
        }
    }


    override fun runMain() {
        main()
    }
}
