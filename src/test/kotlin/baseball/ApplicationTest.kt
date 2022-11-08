package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
   @Test
    fun testGame() {
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
    fun testGame2() {
        assertRandomNumberInRangeTest(
            {
                run("246", "135", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크","게임 종료")
            },
            1, 3, 5
        )
    }

    @Test
    fun testGame3() {
        assertRandomNumberInRangeTest(
            {
                run( "456", "2")
                assertThat(output())
                    .contains("3스트라이크","게임 종료")
            },
            4,5,6
        )
    }

    @Test
    fun errorTestOverThree() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun errorTestNotInt() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("안녕하세요") }
        }
    }

    @Test
    fun errorContainZero() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("012") }
        }
    }

    @Test
    fun errorSame() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("112") }
        }
    }


    override fun runMain() {
        main()
    }
}
