package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTest : NsTest(){

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

    @Test
    fun `게임 진행 관련 key값이 잘못 입력`(){
        assertRandomNumberInRangeTest({
                assertThrows<IllegalArgumentException> { runException("135", "0")}
            },1, 3, 5
        )
    }
    override fun runMain() {
        main()
    }
}