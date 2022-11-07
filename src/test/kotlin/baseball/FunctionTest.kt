package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class FunctionTest : NsTest() {
    @Test
    fun `intToList 테스트`(){
        var user : User = User()
        user.inputNum = 123
        val result = mutableListOf<Int>(1,2,3)
        assertThat(result).isEqualTo(user.intputToList())

    }




    override fun runMain() {
        main()
    }
}
