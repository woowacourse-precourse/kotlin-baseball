package baseball

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows

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

    override fun runMain() {
        main()
    }
}