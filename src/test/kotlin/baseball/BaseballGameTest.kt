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

    @Test
    fun `게임 끝나고 숫자 입력시 1 또는 2가 아니면 Exception 테스트`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                Exception().isValidEndNum("3")
                Exception().isValidEndNum("4")
                Exception().isValidEndNum("a")
                Exception().isValidEndNum("12")
            }
        }
    }

    @Test
    fun `3스트라이크가 아니면 false를 리턴하는지 테스트`() {
        val userList1 = listOf(1, 2, 3)
        val computerList1 = listOf(3, 4, 5)
        val userList2 = listOf(5, 1, 4)
        val computerList2 = listOf(5, 1, 3)
        val userList3 = listOf(6, 7, 3)
        val computerList3 = listOf(6, 3, 7)
        val userList4 = listOf(8, 9, 1)
        val computerList4 = listOf(1, 8, 9)
        Assertions.assertThat(GamePlay().compareUserNumAndComputerNum(computerList1, userList1)).isEqualTo(false)
        Assertions.assertThat(GamePlay().compareUserNumAndComputerNum(computerList2, userList2)).isEqualTo(false)
        Assertions.assertThat(GamePlay().compareUserNumAndComputerNum(computerList3, userList3)).isEqualTo(false)
        Assertions.assertThat(GamePlay().compareUserNumAndComputerNum(computerList4, userList4)).isEqualTo(false)
    }

    @Test
    fun `3스트라이크면 true를 리턴하는지 테스트`() {
        val userList1 = listOf(1, 2, 3)
        val computerList1 = listOf(1, 2, 3)
        val userList2 = listOf(5, 1, 4)
        val computerList2 = listOf(5, 1, 4)
        val userList3 = listOf(6, 7, 3)
        val computerList3 = listOf(6, 7, 3)
        val userList4 = listOf(8, 9, 1)
        val computerList4 = listOf(8, 9, 1)
        Assertions.assertThat(GamePlay().compareUserNumAndComputerNum(computerList1, userList1)).isEqualTo(true)
        Assertions.assertThat(GamePlay().compareUserNumAndComputerNum(computerList2, userList2)).isEqualTo(true)
        Assertions.assertThat(GamePlay().compareUserNumAndComputerNum(computerList3, userList3)).isEqualTo(true)
        Assertions.assertThat(GamePlay().compareUserNumAndComputerNum(computerList4, userList4)).isEqualTo(true)
    }

    override fun runMain() {
        main()
    }
}