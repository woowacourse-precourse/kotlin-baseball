package baseball

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows

class MyTest : NsTest() {

    @Nested
    inner class `사용자 입력 예외 검사` {
        @Test
        fun case1() {
            assertThrows<IllegalArgumentException> { checkValidInput("1234") }
        }

        @Test
        fun case2() {
            assertThrows<IllegalArgumentException> { checkValidInput("123123") }
        }

        @Test
        fun case3() {
            assertThrows<IllegalArgumentException> { checkValidInput("12") }
        }

        @Test
        fun case4() {
            assertThrows<IllegalArgumentException> { checkValidInput("abc") }
        }
    }

    override fun runMain() {
        main()
    }
}