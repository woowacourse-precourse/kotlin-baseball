package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
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
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") } // 입력한 값의 개수가 3보다 클 때
            assertThrows<IllegalArgumentException> { runException("12")} // 입력한 값의 개수가 3보다 작을 때
            assertThrows<IllegalArgumentException> { runException("533")} // 입력한 값에 중복이 있을 때
            assertThrows<IllegalArgumentException> { runException("abc")} // 입력한 값이 숫자가 아닐 때
            assertThrows<IllegalArgumentException> { runException("1 2")} // 입력한 값에 공백이 있을 때
            assertThrows<IllegalArgumentException> { runException("120")} // 입력값에 1~9가 아닌 다른 수가 있을 때
        }
    }

    override fun runMain() {
        main()
    }
}
