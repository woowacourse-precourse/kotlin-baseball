package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest : NsTest(){
    val gl = GameLogic()

    @Test
    fun `중복된 숫자`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> {
                runException("113")
            }
        }
    }

    @Test
    fun `문자가 포함된 숫자`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> {
                runException("1b3")
            }
        }
    }

    @Test
    fun `0이 포함된 숫자`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> {
                runException("023")
            }
        }
    }

    @Test
    fun `3자리가 아닌 숫자`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> {
                runException("1234")
            }
        }
    }
    override fun runMain() {
        main()
    }
}