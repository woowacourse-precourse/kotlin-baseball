package baseball

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class `Game 파일의` {

    @Nested
    inner class `createComputerNumber 메소드는` {

        @Nested
        inner class `실행하면` {

            @Test
            fun `0을 제외한 서로 다른 3개의 숫자로 이루어진 문자열을 반환한다`() {
                val computerNumber = createComputerNumber()

                assertThat(computerNumber).hasSize(3)
                assertThat(computerNumber).containsAnyOf("1", "2", "3", "4", "5", "6", "7", "8", "9")
                computerNumber.forEach { assertThat(computerNumber).containsOnlyOnce(it.toString()) }
            }
        }
    }

    @Nested
    inner class `ballCount 메소드는` {

        @Nested
        inner class `컴퓨터의 숫자와 사용자의 응답을 받으면` {
            private val computerNumber = "123"
            private val answer = "234"

            @Test
            fun `사용자의 입력값 중 컴퓨터의 숫자에 포함되어 있고 다른 자리에 있는 숫자의 개수를 반환한다`() {
                val ballCount = ballCount(computerNumber, answer)

                assertThat(ballCount).isEqualTo(2)
            }
        }
    }

    @Nested
    inner class `strikeCount 메소드는` {

        @Nested
        inner class `컴퓨터의 숫자와 사용자의 응답을 받으면` {
            private val computerNumber = "123"
            private val answer = "423"

            @Test
            fun `사용자의 입력값 중 컴퓨터의 숫자에 포함되어 있고 같은 자리에 있는 숫자의 개수를 반환한다`() {
                val strikeCount = strikeCount(computerNumber, answer)

                assertThat(strikeCount).isEqualTo(2)
            }

        }
    }

    @Nested
    inner class `createHint 메소드는` {

        @Nested
        inner class `볼과 스트라이크의 개수가 둘 다 0이라면` {
            private val computerNumber = "123"
            private val answer = "456"

            @Test
            fun `낫싱이라는 글자를 반환한다`() {
                val hint = createHint(computerNumber, answer)

                assertThat(hint).isEqualTo("낫싱")
            }
        }

        @Nested
        inner class `볼의 개수는 1 이상이고 스트라이크의 개수가 0이라면` {
            private val computerNumber = "123"
            private val answer = "234"
            @Test
            fun `볼의 개수만 알려주는 힌트를 반환한다`() {
                val hint = createHint(computerNumber, answer)

                assertThat(hint).contains("볼").doesNotContain("스트라이크")
            }
        }

        @Nested
        inner class `볼의 개수는 0이고 스트라이크의 개수가 1 이상이라면` {
            private val computerNumber = "123"
            private val answer = "145"
            @Test
            fun `스트라이크의 개수만 알려주는 힌트를 반환한다`() {
                val hint = createHint(computerNumber, answer)

                assertThat(hint).doesNotContain("볼").contains("스트라이크")
            }
        }

        @Nested
        inner class `볼의 개수와 스트라이크의 개수가 둘 다 1 이상이라면` {
            private val computerNumber = "123"
            private val answer = "134"

            @Test
            fun `둘의 개수를 알려주는 힌트를 반환한다`() {
                val hint = createHint(computerNumber, answer)

                assertThat(hint).contains("볼", "스트라이크")
            }
        }
    }
}