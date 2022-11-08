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
    fun `유효하지 않은 입력 값에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException("1234") // 3자리 수가 아닌 경우
                runException("0")    // 1~9까지의 범위를 벗어난 경우
                runException("dfs")  // 문자가 포함된 경우
                runException("222")  // 중복된 숫자가 있는 경우
            }
        }
    }

    @Nested
    inner class HintTest {
        @Test
        fun case1() {
            val input = "123"
            val answer = "341"
            val result = "2볼"
            assertThat(getHint(input, answer)).isEqualTo(result)
        }

        @Test
        fun case2() {
            val input = "962"
            val answer = "169"
            val result = "1볼 1스트라이크"
            assertThat(getHint(input, answer)).isEqualTo(result)
        }

        @Test
        fun case3() {
            val input = "345"
            val answer = "145"
            val result = "2스트라이크"
            assertThat(getHint(input, answer)).isEqualTo(result)
        }

        @Test
        fun case4() {
            val input = "345"
            val answer = "298"
            val result = "낫싱"
            assertThat(getHint(input, answer)).isEqualTo(result)
        }

    }

    @Test
    fun `컴퓨터의 랜덤 숫자 생성`() {

    }

    @Test
    fun `사용자로부터 입력 받기`() {

    }

    @Test
    fun `입력값에 따라 게임 재시작 혹은 종료`() {

    }

    override fun runMain() {
        main()
    }
}
