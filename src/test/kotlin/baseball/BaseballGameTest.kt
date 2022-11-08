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

    @Test
    fun `유저의 입력의 각 자리수의 숫자가 중복이면 Exception 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            val inputList1 = listOf<Int>(1, 1, 5)
            val inputList2 = listOf<Int>(4, 2, 2)
            val inputList3 = listOf<Int>(8, 3, 8)
            assertThrows<IllegalArgumentException> {
                Exception().isDistinctNum(inputList1)
                Exception().isDistinctNum(inputList2)
                Exception().isDistinctNum(inputList3)
            }
        }
    }
    
    override fun runMain() {
        main()
    }
}