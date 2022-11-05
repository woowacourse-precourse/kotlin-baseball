package baseball

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomTest : NsTest() {
    override fun runMain() {
        main()
    }

    @Test
    fun `문자열 포함시 에러 반환여부 체크`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("6r4") }
        }
    }

    @Test
    fun `길이 3이상 입력시 에러 반환여부 체크`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("6547") }
        }
    }

    @Test
    fun `중복문자 포함시 에러 반환여부 체크`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("644") }
        }
    }

    @Test
    fun `0 포함시 에러 반환여부 체크`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("604") }
        }
    }

    @Test
    fun `바로 통과 후 재시작 안할 경우`() {
        Assertions.assertRandomNumberInRangeTest(
            {
                run("523", "2")
                org.assertj.core.api.Assertions.assertThat(output())
                    .contains("3스트라이크")
            },
            5, 2, 3
        )
    }

    @Test
    fun `바로 통과 후 재시작 할 경우`() {
        Assertions.assertRandomNumberInRangeTest(
            {
                run("523", "1", "123", "2")
                org.assertj.core.api.Assertions.assertThat(output())
                    .contains("3스트라이크")
            },
            5, 2, 3, 1, 2, 3
        )
    }

    @Test
    fun `통과 후 재시작에 문자열 넣어보기 `() {
        Assertions.assertRandomNumberInRangeTest(
            {
                run("325", "ㄱ", "2")
                org.assertj.core.api.Assertions.assertThat(output())
                    .contains("3스트라이크")
            },
            3, 2, 5
        )
    }
}