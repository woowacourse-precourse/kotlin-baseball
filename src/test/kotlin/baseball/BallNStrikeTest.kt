package baseball

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BallNStrikeTest {

    @Test
    fun `ball strike 테스트`() {
        var comNum = listOf<Int>(1,3,4)
        var userNum1= listOf<Int>(1,2,3)
        var answer1= listOf<Int>(1,1)
        var result1=getBallAndStrike(comNum,userNum1)
        Assertions.assertThat(result1).isEqualTo(answer1)

        var userNum2= listOf<Int>(5,6,7)
        var answer2= listOf<Int>(0,0)
        var result2=getBallAndStrike(comNum,userNum2)
        Assertions.assertThat(result2).isEqualTo(answer2)

        var userNum3= listOf<Int>(1,3,4)
        var answer3= listOf<Int>(0,3)
        var result3=getBallAndStrike(comNum,userNum3)
        Assertions.assertThat(result3).isEqualTo(answer3)

        var userNum4= listOf<Int>(4,1,3)
        var answer4= listOf<Int>(3,0)
        var result4=getBallAndStrike(comNum,userNum4)
        Assertions.assertThat(result4).isEqualTo(answer4)

    }
}