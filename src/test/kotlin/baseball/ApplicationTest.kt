package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {

    @Test
    fun `정답을 맞췄을 때 정상적으로 종료할 수 있는지 테스트`() {
        assertRandomNumberInRangeTest(
                {
                    run("237", "2")
                    assertThat(output())
                            .contains("3스트라이크", "게임 종료")
                },
                2,3,7
        )
    }

    @Test
    fun `낫싱 볼 스트라이크 개수 테스트`() {
        assertRandomNumberInRangeTest(
                {
                    run("789", "351", "513", "531", "134", "135", "2")
                    assertThat(output())
                            .contains("낫싱", "3볼", "3볼", "2볼 1스트라이크", "2스트라이크", "3스트라이크", "게임 종료")
                },
                1,3,5
        )
    }
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
    fun `게임 재시작 질문에서 잘못된 값 입력 시 테스트`() {
        assertRandomNumberInRangeTest(
            {
                 assertThrows<IllegalArgumentException> { runException("135", "3") }
            },
                1, 3, 5
        )
    }

    /* 입력한 숫자가 조건에 부합하는지 검사 - 3자리인가? */
    @Test
    fun `3자리 이상의 숫자 입력 시 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `3자리 이하의 숫자 입력 시 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12") }
        }
    }

    /* 입력한 숫자가 조건에 부합하는지 검사 - 각 자리의 숫자 범위가 1~9인가? */
    @Test
    fun `범위 밖 숫자 입력 시 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("100") }
        }
    }

    /* 입력한 숫자가 조건에 부합하는지 검사 - 각 자리의 숫자들이 서로 다른가? */
    @Test
    fun `같은 숫자 입력 시 예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("111") }
        }
    }

    /* 함수별 테스트, 위에 포함되는 테스트는 제외함 */
    @Test
    fun `pickNumbersSizeTest`() {
        val result = pickNumbers()
        assertThat(result.size).isEqualTo(3)
    }

    @Test
    fun `pickNumbersDifferentEachTest`() {
        val result = pickNumbers()
        var isCorrect = true
        for (i in 0..2) {
            isCorrect = result.count { it == result[i] } == 1
        }
        assertThat(isCorrect).isEqualTo(true)
    }
    @Test
    fun `pickNumberRangeTest`() {
        val result = pickNumbers()
        var isCorrect = true
        for (i in 0..2) {
            isCorrect = result[i].isDigit()
        }
        assertThat(isCorrect).isEqualTo(true)
    }
    @Test
    fun `judgeNumbersTest`() {
        val result = judgeNumbers(listOf('1','2','3'), listOf('2','1','3'))
        assertThat(result).isEqualTo(listOf(2, 1))
    }
    @Test
    fun `printResult`() {
        printResult(listOf(1, 1))
        assertThat(output()).contains("1볼 1스트라이크")
    }
    override fun runMain() {
        main()
    }
}
