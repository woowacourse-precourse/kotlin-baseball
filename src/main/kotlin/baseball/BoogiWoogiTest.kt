package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BoogiWoogiTest {
    @Test
    fun `사용자의 입력이 숫자가 아닌 경우 예외 발생`(){
        assertThrows<IllegalArgumentException> {
            checkException("우테코 합격기원")
        }
    }

    @Test
    fun `사용자의 입력이 세자리가 아닌 경우 예외 발생`(){
        assertThrows<IllegalArgumentException> {
            checkException("7777")
        }
    }

    @Test
    fun `컴퓨터가 발생시킨 임의의 숫자 리스트 크기가 3인지 확인`(){
        Computer.generateNewRandomNumbers()
        assertThat(Computer.randomNumbers.size).isEqualTo(3)
    }

    @Test
    fun `스트라이크된 숫자의 개수가 하나인 경우`(){
        Computer.randomNumbers=arrayListOf(3, 5, 4)
        assertThat(BaseballGameReferee.calcStrikeCount(arrayListOf(4, 5, 1))).isEqualTo(1)
    }

    @Test
    fun `스트라이크된 숫자의 개수가 두개인 경우`(){
        Computer.randomNumbers=arrayListOf(1, 5, 4)
        assertThat(BaseballGameReferee.calcStrikeCount(arrayListOf(1, 2, 4))).isEqualTo(2)
    }

    @Test
    fun `스트라이크된 숫자의 개수가 세개인 경우`(){
        Computer.randomNumbers=arrayListOf(1, 5, 4)
        assertThat(BaseballGameReferee.calcStrikeCount(arrayListOf(1, 5, 4))).isEqualTo(3)
    }

}