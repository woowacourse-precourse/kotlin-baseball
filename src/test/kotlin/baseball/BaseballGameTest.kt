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
    
    override fun runMain() {
        main()
    }
}