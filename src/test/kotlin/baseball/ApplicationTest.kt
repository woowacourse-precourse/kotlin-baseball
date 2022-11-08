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
    fun `볼, 스트라이크, 낫싱 처리 재확인`() {
        assertRandomNumberInRangeTest(
            {
                run("456", "351", "125", "132", "123", "1", "456", "2")
                assertThat(output())
                    .contains("낫싱", "2볼", "2스트라이크", "2볼 1스트라이크", "3스트라이크", "3스트라이크", "게임 종료")
            },
            1, 2, 3, 4, 5, 6
        )
    }

    @Test
    fun `재시작 시 1~2 이외의 숫자를 입력할 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("842", "0", "8", "2")
                assertThat(output())
                    .contains("3스트라이크", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", "게임 종료")
            },
            8, 4, 2
        )
    }


    @Test
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }

    @Nested
    inner class UserNumTest {
        @Test
        fun `입력값 테스트 - 숫자가 아닐 경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("qa") }
            }
        }

        @Test
        fun `입력값 테스트 - 1 ~ 9 범위 밖일 경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("043") }
            }
        }

        @Test
        fun `입력값 테스트 - 입력값이 3개가 아닐경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("15") }
            }
        }

        @Test
        fun `입력값 테스트 - 중복값이 존재할 경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException("515") }
            }
        }

        @Test
        fun `입력값 테스트 - 빈 값일 경우`() {
            assertSimpleTest {
                assertThrows<IllegalArgumentException> { runException(" ") }
            }
        }

    }

    override fun runMain() {
        main()
    }


}
