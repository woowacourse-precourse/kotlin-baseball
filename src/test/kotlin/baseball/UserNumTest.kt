package baseball

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class UserNumTest {

    @Test
    fun `사용자의 입력 유효 여부 테스트`() {
        val goodInput=456
        val badInput1=-123
        val badInput2=122
        val badInput3=102
        val badInput4=111
        val badInput5=-12
        var goodResult= isValidNum(goodInput)
        var badResult1= isValidNum(badInput1)
        var badResult2= isValidNum(badInput2)
        var badResult3= isValidNum(badInput3)
        var badResult4= isValidNum(badInput4)
        var badResult5= isValidNum(badInput5)
        Assertions.assertThat(goodResult).isTrue()
        Assertions.assertThat(badResult1).isFalse()
        Assertions.assertThat(badResult2).isFalse()
        Assertions.assertThat(badResult3).isFalse()
        Assertions.assertThat(badResult4).isFalse()
        Assertions.assertThat(badResult5).isFalse()
    }

}