package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.provider.CsvSource

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
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Test
    fun `숫자의 개수가 2개일 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("23") }
        }
    }

    @Test
    fun `중복 숫자가 있을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("233") }
        }
    }

    @Test
    fun `숫자가 아닌 문자가 있을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("2_3") }
        }
    }

    @Test
    fun `입력 숫자의 범위를 벗어났을 때`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("012") }
        }
    }




    override fun runMain() {
        main()
    }
}
