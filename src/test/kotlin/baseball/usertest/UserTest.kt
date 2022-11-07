package baseball.usertest

import baseball.logic.User
import baseball.main
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UserTest: NsTest() {
    @Test
    fun `numberFormatting Test`() {
        val user = User()
        user.numberFormatting(123)
        Assertions.assertThat(user.number).isEqualTo(intArrayOf(1,2,3))
    }

    @Test
    fun `compareWithAnswer Test`() {
        val user = User()
        user.number = intArrayOf(1,2,3)
        Assertions.assertThat(user.compareWithAnswer(intArrayOf(1,3,2))).isEqualTo(intArrayOf(1,2))
    }

    override fun runMain() {
        main()
    }
}