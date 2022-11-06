package baseball

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RandomNumTest {

    @Test
    fun `1부터 9까지의 3자리의 수 생성`() {
        for(i in 0 until 99){
            var result= makeRandomNum()
            println(result)
            Assertions.assertThat(result).doesNotContain(0)
            Assertions.assertThat(result.size).isEqualTo(3)

        }

    }
    @Test
    fun `중복이 없는 3자리 수 생성`() {
        var isDuplicate=true
        var result= makeRandomNum()
        for(i in 0 until 99){
            if(result[0]==result[1] || result[0]==result[2] || result[1]==result[2]){
                isDuplicate=false
            }
            println(isDuplicate)
            Assertions.assertThat(isDuplicate).isTrue()
        }
    }

}