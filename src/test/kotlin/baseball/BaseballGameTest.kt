package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseballGameTest {
    @Test
    fun `3자리보다 큰 수를 입력할 경우`(){
        assertThrows<IllegalArgumentException> {
            val input = mutableListOf(1,2,3,4,5)
            playerInputValidCheck(input)
        }
    }

    @Test
    fun `3자리보다 작은 수를 입력할 경우`(){
        assertThrows<IllegalArgumentException> {
            val input = mutableListOf(1)
            playerInputValidCheck(input)
        }
    }

    @Test
    fun `서로 중복되는 수를 입력할 경우`(){
        assertThrows<IllegalArgumentException> {
            val input = mutableListOf(1,1,2)
            playerInputValidCheck(input)
        }
    }

    @Test
    fun `숫자를 띄워서 입력할 경우`(){
        assertThrows<IllegalArgumentException> {
            val input = "1 2 3"
            playerInputToList(input)
        }
    }

    @Test
    fun `숫자가 아닌 글자를 입력할 경우`(){
        assertThrows<IllegalArgumentException> {
            val input = "OIE"
            playerInputToList(input)
        }
    }

    @Test
    fun `게임 진행 여부에 1 또는 2가 아닌 숫자를 입력할 경우`(){
        assertThrows<IllegalArgumentException> {
            val input = 3
            gameMenu(input)
        }
    }

}