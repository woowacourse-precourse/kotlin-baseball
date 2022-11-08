package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CustomTest : NsTest() {
    @Test
    fun `(1,4,5), (3,5,9) 케이스의 게임시작 및 종류 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("123", "456", "145", "1", "352", "394", "359", "2")
                assertThat(output())
                    .contains("1스트라이크", "2볼", "게임 종료", "2스트라이크", "1볼 1스트라이크", "3개의 숫자를 모두 맞히셨습니다!")
            },
            1, 4, 5, 3, 5, 9 // Random.class의 Mock을 생성하여 랜덤값으로 들어오는 값들을 1, 4, 5... 로 정한다.
        )
    }

    @Test
    fun `사용자 입력 예외 테스트`() {
        val userInputs = listOf<String>("fas", "212", "32s", "@DS")
        userInputs.forEach { case ->
            assertSimpleTest {
                assertThrows<IllegalArgumentException> {
                    runException(case)
                }
            }
        }
    }

    override fun runMain() {
        main()
    }
}
