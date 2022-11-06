package baseball

import baseball.model.ComputerNumber
import baseball.model.UserNumber
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class BaseBallTest {

     private var computernumber = ComputerNumber()
     private var usernumber = UserNumber()
     private var check = ExceptionCheck()

//    @Test
//    fun 컴퓨터_숫자_검증() {
//        computernumber.setComputerNumber()
//        println(computernumber.ComputerList)
//        assertEquals(computernumber.ComputerList.size , 3)
//    }
//
//    @Test
//    fun 사용자_입력_확인() {
//
//    }

    @Test
    fun 입력값_자릿수_확인_예외처리() {
       assertThrows<IllegalArgumentException> {
           check.checkDigit("123")
       }
    }

    @Test
    fun 입력값_범위_확인_예외처리() {
        assertThrows<IllegalArgumentException> {
            check.checkHaveZero("123")
        }
    }

    @Test
    fun 입력값_중복_확인_예외처리() {

        assertThrows<IllegalArgumentException> {
            check.checkOverlap("123")
        }
    }
}