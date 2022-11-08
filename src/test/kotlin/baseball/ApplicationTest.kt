package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `test00`(){
        assertRandomNumberInRangeTest(
            {
                run("246", "135", "1", "597", "589", "2")
                assertThat(output())
                    .contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료")
            },
            1, 3, 5, 5, 8, 9
        )
    }
    @Test
    fun `test01`(){
        assertRandomNumberInRangeTest(
            {
                run("123", "1", "789", "165", "256", "356", "456", "2")
                assetThat(output())
                    .contains("3스트라이크","낫싱","2볼","2스트라이크","2스트라이크","3스트라이크","게임 종료")
            },
            1, 2, 3, 4, 5, 6
        )
    }
    @Test
    fun `test02`(){
        assertRandomNumberInRangeTest(
            {
                run("123","456","789","1","123","124","135","2")
                assetThat(output())
                    .contains("낫싱","낫싱","3스트라이크","1볼1스트라이크","1스트라이크","3스트라이크","게임 종료")
                },
            7, 8, 9, 1, 3, 5
        )
    }
    @Test
    fun `test03`(){
        assertRandomNumberInRangeTest(
            {
                run("642", "426", "246", "1","123","234","345","367","368","379","2")
                assetThat(output())
                    .contains("3볼", "2볼1스트라이크", "3스트라이크","1볼","1볼","1볼","2볼","1볼","3스트라이크","게임 종료")
                
            },
            2, 4, 6, 3, 7, 9
        )
    }
    @Test
    fun `예외 테스트 00 : 3자리수가 아닌 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }
    @Test
    fun `예외 테스트 01 : 같은 수가 들어온 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1134") }
        }
    }
    @Test
    fun `예외 테스트 02 : 1~9사이 수가 아닌 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("034") }
        }
    }
    @Test
    fun `예외 테스트 03 : 숫자가 아닌 문자열이 입력된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("12a") }
        }
    }
    @Test
    fun `예외 테스트 04 : 게임종료시 1 OR 2 이외의 값이 입력된 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("4") }
        }
    }

    override fun runMain() {
        main()
    }
}
