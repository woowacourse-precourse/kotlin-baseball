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

    @Test
    fun `입력값이 중복된 값이 있는지 체크`(){
        val input = Game.checkInputDuplication("112")
        assertThat(input).isEqualTo(false)
    }

    @Test
    fun `입력값이 숫자외 다른 값이 있는지 체크`(){
        val input = Game.checkInputValueIsNumber("11a")
        assertThat(input).isEqualTo(false)
    }
}