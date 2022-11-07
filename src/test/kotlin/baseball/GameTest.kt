package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class GameTest (){
    @Test
    fun `입력값이 3자리 수인지 체크`(){
        val input = Game.checkInputLengthThree("123")
        assertThat(input).isEqualTo(true)
    }
}