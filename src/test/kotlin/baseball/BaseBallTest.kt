package baseball

import baseball.model.ComputerNumber
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


class BaseBallTest {

     private var computernumber = ComputerNumber()
     private var check = ExceptionCheck()


    @Test
    fun 컴퓨터_숫자_검증() {

        println(computernumber.setComputerNumber())
        assertEquals(computernumber.setComputerNumber(), 3)
    }

    @Test
    fun 사용자_입력_확인() {

    }

    @Test
    fun 입력값_자릿수_확인_예외처리() {
       assertThrows<IllegalArgumentException> {
           check.checkDigit("12")
       }
    }

    @Test
    fun 입력값_범위_확인_예외처리() {
        assertThrows<IllegalArgumentException> {
            check.checkHaveZero("120")
        }
    }

    @Test
    fun 입력값_중복_확인_예외처리() {

        assertThrows<IllegalArgumentException> {
            check.checkOverlap("122")
        }
    }
}