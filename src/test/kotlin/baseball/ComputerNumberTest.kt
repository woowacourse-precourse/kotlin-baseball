package baseball

import baseball.model.ComputerNumber
import org.junit.jupiter.api.Assertions.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


class ComputerNumberTest {

     private var number = ComputerNumber()

    @Test
    fun 컴퓨터_숫자_검증() {
        number.setComputerNumber()
        println(number.ComputerList)
        assertEquals(number.ComputerList.size , 3)
    }
}