package baseball


import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameTest : NsTest() {

    val game = Game()

    @Nested
    inner class `입력값의 유효성을 검사` {
        @Test
        fun case1() {
            val inputNumber = "123"
            val invalidator = InputValidation(inputNumber)
            assertTrue(invalidator.inputNumberExceptionCheck())
        }

        @Test
        fun case2() {
            val inputNumber = "12"
            val invalidator = InputValidation(inputNumber)
            assertThrows<IllegalArgumentException> {
                invalidator.inputNumberExceptionCheck()
            }
        }

        @Test
        fun case3() {
            val inputNumber = "12/"
            val invalidator = InputValidation(inputNumber)
            assertThrows<IllegalArgumentException> {
                invalidator.inputNumberExceptionCheck()
            }
        }

        @Test
        fun case4() {
            val inputNumber = "122"
            val invalidator = InputValidation(inputNumber)
            assertThrows<IllegalArgumentException> {
                invalidator.inputNumberExceptionCheck()
            }
        }

        @Test
        fun case5() {
            val inputNumber = "120"
            val invalidator = InputValidation(inputNumber)
            assertThrows<IllegalArgumentException> {
                invalidator.inputNumberExceptionCheck()
            }
        }
    }

    @Nested
    inner class `사용자 입력값과 컴퓨터 랜덤값 비교` {
        @Test
        fun case1() {
            val inputNumber = "123"
            val computerRandomNumber = listOf(1, 2, 3)
            val strikeOrBall = Judgement(inputNumber.map { it.digitToInt() }.toList(), computerRandomNumber)
                .judgeTheBall()
            assertThat(strikeOrBall).isEqualTo(listOf(3, 0))
        }

        @Test
        fun case2() {
            val inputNumber = "234"
            val computerRandomNumber = listOf(1, 2, 3)
            val strikeOrBall = Judgement(inputNumber.map { it.digitToInt() }.toList(), computerRandomNumber)
                .judgeTheBall()
            assertThat(strikeOrBall).isEqualTo(listOf(0, 2))
        }

        @Test
        fun case3() {
            val inputNumber = "567"
            val computerRandomNumber = listOf(1, 2, 3)
            val strikeOrBall = Judgement(inputNumber.map { it.digitToInt() }.toList(), computerRandomNumber)
                .judgeTheBall()
            assertThat(strikeOrBall).isEqualTo(listOf(0, 0))
        }

        @Test
        fun case4() {
            val inputNumber = "132"
            val computerRandomNumber = listOf(1, 2, 3)
            val strikeOrBall = Judgement(inputNumber.map { it.digitToInt() }.toList(), computerRandomNumber)
                .judgeTheBall()
            assertThat(strikeOrBall).isEqualTo(listOf(1, 2))
        }
    }

    @Nested
    inner class `스트라이크 판정 결과 출력` {
        @Test
        fun case1() {
            val strikeOrBall = listOf(1, 2)
            game.successOrNot(strikeOrBall as MutableList<Int>)
            assertThat(output()).contains("2볼 1스트라이크")
        }

        @Test
        fun case2() {
            val strikeOrBall = listOf(0, 0)
            game.successOrNot(strikeOrBall as MutableList<Int>)
            assertThat(output()).contains("낫싱")
        }

        @Test
        fun case3() {
            val strikeOrBall = listOf(3, 0)
            game.successOrNot(strikeOrBall as MutableList<Int>)
            assertThat(output()).contains("3스트라이크")
        }

    }

    @Nested
    inner class `재시작 또는 종료 입력 받기` {
        @Test
        fun case1() {
            val input = "1"
            assertFalse(game.restartOrEndBaseball(input))
        }

        @Test
        fun case2() {
            val input = "2"
            assertTrue(game.restartOrEndBaseball(input))
        }

        @Test
        fun case3() {
            val input = "3"
            assertThrows<IllegalArgumentException> {
                game.restartOrEndBaseball(input)
            }
        }
    }

    override fun runMain() {
        main()
    }
}