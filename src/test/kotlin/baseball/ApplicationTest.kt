package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `입력값데이터타입1`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(null) }
        }
    }

    @Test
    fun `입력값데이터타입2`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12a") }
        }
    }

    @Test
    fun `입력값범위`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("120") }
        }
    }

    @Test
    fun `입력중복`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("122") }
        }
    }

    @Test
    fun `!입력3자리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `게임종료 후 재시작 if 1`() {
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
    fun `게임종료 if 2`() {
        assertRandomNumberInRangeTest(
            {
                run("135", "2")
                assertThat(output())
                    .contains("3스트라이크", "게임 종료")
            },
            1, 3, 5
        )
    }

    @Test
    fun `게임종료 else`() {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException> { runException("135", "3") }
            },
            1, 3, 5
        )
    }

    override fun runMain() {
        main()
    }
}