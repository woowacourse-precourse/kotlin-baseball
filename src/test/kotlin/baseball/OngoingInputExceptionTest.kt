package baseball

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class OngoingInputExceptionTest: NsTest() {
    @Test
    fun `커스텀 예외 테스트 ONGOING_INPUT 일떄 숫자가 아닌입력(특수문자 포함)`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException>("입력이 숫자타입이 아닙니다") { runException("!34") }
        }
    }

    @Test
    fun `커스텀 예외 테스트 ONGOING_INPUT 일떄 숫자가 아닌입력(알파벳 포함)`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException>("입력이 숫자타입이 아닙니다") { runException("a23") }
        }
    }

    @Test
    fun `커스텀 예외 테스트 ONGOING_INPUT 일떄 적은 숫자입력`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException>("입력된 숫자의 길이가 적절치 않습니다.") { runException("12") }
        }
    }

    @Test
    fun `커스텀 예외 테스트 ONGOING_INPUT 일떄 큰 숫자 입력`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException>("입력된 숫자의 길이가 적절치 않습니다.") { runException("1234") }
        }
    }

    @Test
    fun `커스텀 예외 테스트 ONGOING_INPUT 일떄 중복된 숫자 입력`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException>("중복된 숫자가 입력되었습니다.") { runException("223") }
        }
    }

    override fun runMain() {
        main()
    }
}
