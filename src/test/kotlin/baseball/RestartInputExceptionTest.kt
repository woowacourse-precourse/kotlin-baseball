package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RestartInputExceptionTest : NsTest() {

    @Test
    fun `게임 재시작 상황에서 예외 입력 들어왔을떄 (알파벳)`() {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException>("입력이 숫자타입이 아닙니다") {
                    runException("246", "135", "1", "597", "589", "a")
                }
            },
            1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `게임 재시작 상황에서 예외 입력 들어왔을떄 (다른숫자)`() {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException>("입력이 숫자타입이 아닙니다") {
                    runException("246", "135", "1", "597", "589", "5")
                }
            },
            1, 3, 5, 5, 8, 9
        )
    }

    @Test
    fun `게임 재시작 상황에서 예외 입력 들어왔을떄 (한글)`() {
        assertRandomNumberInRangeTest(
            {
                assertThrows<IllegalArgumentException>("입력이 숫자타입이 아닙니다") {
                    runException("246", "135", "1", "597", "589", "ㄱ")
                }
            },
            1, 3, 5, 5, 8, 9
        )
    }

    override fun runMain() {
        main()
    }
}
