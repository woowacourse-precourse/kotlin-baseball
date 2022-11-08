package baseball

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseballGameTest : NsTest() {
    @Test
    fun `유저의 숫자를 리스트로 반환하는지 테스트`() {
        val input = "123"
        val result = listOf<Int>(1, 2, 3)
        Assertions.assertThat(GamePlay().getUserNumAndReturnList(input)).isEqualTo(result)
    }

    @Test
    fun `유저의 입력의 각 자리수가 1~9의 숫자가 아니면 Exception 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Exception().isInValidNum("103")
                Exception().isInValidNum("14a")
                Exception().isInValidNum("1")
            }
        }
    }

    override fun runMain() {
        main()
    }
}