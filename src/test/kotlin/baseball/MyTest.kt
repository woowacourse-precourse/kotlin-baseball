package baseball

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse

class MyTest : NsTest() {

    @Nested
    inner class `사용자 입력 예외 검사` {
        @Test
        fun case1() {
            assertThrows<IllegalArgumentException> { checkValidInput("1234") }
        }

        @Test
        fun case2() {
            assertThrows<IllegalArgumentException> { checkValidInput("123123") }
        }

        @Test
        fun case3() {
            assertThrows<IllegalArgumentException> { checkValidInput("12") }
        }

        @Test
        fun case4() {
            assertThrows<IllegalArgumentException> { checkValidInput("abc") }
        }
    }


    @Nested
    inner class `볼, 스트라이크 개수 확인` {
        @Test
        fun case1() {
            val result = countBallStrike(listOf(1, 2, 3), listOf(4, 5, 6))
            assertThat(result).isEqualTo(listOf(0, 0))
        }

        @Test
        fun case2() {
            val result = countBallStrike(listOf(1, 2, 3), listOf(3, 4, 5))
            assertThat(result).isEqualTo(listOf(1, 0))
        }

        @Test
        fun case3() {
            val result = countBallStrike(listOf(1, 2, 3), listOf(1, 3, 2))
            assertThat(result).isEqualTo(listOf(2, 1))
        }


        @Test
        fun case4() {
            val result = countBallStrike(listOf(1, 2, 3), listOf(1, 2, 5))
            assertThat(result).isEqualTo(listOf(0, 2))
        }

        @Test
        fun case5() {
            val result = countBallStrike(listOf(1, 2, 3), listOf(1, 2, 3))
            assertThat(result).isEqualTo(listOf(0, 3))
        }
    }

    @Nested
    inner class `게임 결과 검사` {
        @Test
        fun case1() {
            val result = getGameResult(listOf(1, 2, 3), listOf(4, 5, 6))
            assertThat(result).isEqualTo("낫싱")
        }

        @Test
        fun case2() {
            val result = getGameResult(listOf(1, 2, 3), listOf(3, 4, 5))
            assertThat(result).isEqualTo("1볼")
        }

        @Test
        fun case3() {
            val result = getGameResult(listOf(1, 2, 3), listOf(1, 2, 5))
            assertThat(result).isEqualTo("2스트라이크")
        }

        @Test
        fun case4() {
            val result = getGameResult(listOf(1, 2, 3), listOf(1, 3, 2))
            assertThat(result).isEqualTo("2볼 1스트라이크")
        }
    }

    @Test
    fun `정답일때 true 반환, 게임 종료 문구 출력하는지 검사`() {
        assertTrue(checkCorrectAnswer("3스트라이크"))
        assertThat(output())
            .contains("게임 종료")
    }

    @Test
    fun `정답이 아닐 때 false 반환, 게임 종료 문구 출력 안하는지 검사`() {
        assertFalse(checkCorrectAnswer("2스트라이크"))
        assertThat(output())
            .doesNotContain("게임 종료")
    }

    @Nested
    inner class `게임 재시작 입력 예외 검사` {
        @Test
        fun case1() {
            Assertions.assertRandomNumberInRangeTest(
                {
                    assertThrows<IllegalArgumentException> {
                        run("123", "3")
                    }
                },
                1, 2, 3
            )
        }

        @Test
        fun case2() {
            Assertions.assertRandomNumberInRangeTest(
                {
                    assertThrows<IllegalArgumentException> {
                        run("123", "a")
                    }
                },
                1, 2, 3
            )
        }
    }

    override fun runMain() {
        main()
    }
}