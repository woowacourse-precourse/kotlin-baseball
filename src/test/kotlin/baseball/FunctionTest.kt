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
        val result = mutableListOf<Int>(1,2,3)
        assertThat(result).isEqualTo(intToList(123))

    }
    @Test
    fun `countingStrikeBall 테스트`(){
        val result= mutableListOf<Int>(1,2)
        assertThat(result).isEqualTo(countingStrikeBall(listOf(1,2,3), listOf(1,3,2)))
    }



    override fun runMain() {
        main()
    }
}
