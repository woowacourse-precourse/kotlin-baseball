package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `난수 생성 테스트`() {
        val createList = createRandomNumber()
        assertThat(createList).hasSize(3)
        print(createList.toString())
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
    fun `예외 테스트 길이`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `예외 테스트 숫자` () {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("a12") }
        }
    }

    @Test
    fun `예외 테스트 중복` () {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("113") }
        }
    }

    override fun runMain() {
        main()
    }
}
