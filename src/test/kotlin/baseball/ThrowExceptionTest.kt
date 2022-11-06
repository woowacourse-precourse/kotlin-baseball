package baseball

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ThrowExceptionTest {
    private val throwException = ThrowException()

    @Test
    fun `3자리 숫자를 입력할 때 숫자가 아닐 경우 예외 발생`(){
        val input = "12a"
        assertThrows<IllegalArgumentException>("입력한 값이 숫자가 아닙니다."){
            throwException.throwExceptionForUserNumber(input)
        }
    }

    @Test
    fun `3자리 숫자를 입력할 때 중복된 값이 있을 경우 예외 발생`(){
        val input = "122"
        assertThrows<IllegalArgumentException>("입력한 숫자들 중 중복된 숫자가 있습니다."){
            throwException.throwExceptionForUserNumber(input)
        }
    }

    @Test
    fun `3자리 숫자를 입력할 때 3자리 숫자가 아닐 경우 예외 발생`(){
        val input = "12"
        assertThrows<IllegalArgumentException>("입력한 수가 3자릿수가 아닙니다."){
            throwException.throwExceptionForUserNumber(input)
        }
    }

    @Test
    fun `게임 종료시에 사용자가 입력값이 숫자가 아닐 경우 예외 발생`(){
        val input = "ㅁ"
        assertThrows<IllegalArgumentException>("입력한 값이 숫자가 아닙니다."){
            throwException.throwExceptionForRestartNumber(input)
        }
    }

    @Test
    fun `게임 종료시에 사용자가 입력값이 1과 2가 아닐 경우 예외 발생`(){
        val input = "3"
        assertThrows<IllegalArgumentException>("입력한 수가 올바른 값이 아닙니다"){
            throwException.throwExceptionForRestartNumber(input)
        }
    }
}