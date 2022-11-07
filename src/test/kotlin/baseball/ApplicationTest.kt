package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ApplicationTest : NsTest() {
    @Test
    fun `게임종료 후 재시작`() {
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
    fun `예외 테스트`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("1234") }
        }
    }
    @Test
    fun `generateAnswer 메소드 반환 결과 확인`() {
        val baseBallGame = BaseBallGame()
        val method = baseBallGame.javaClass.getDeclaredMethod("generateAnswer")
        method.isAccessible = true

        val parameters = arrayOfNulls<Any>(0)
        val getElement: String = method.invoke(baseBallGame, *parameters) as String
        val guessRegex = "[1-9]{3}".toRegex()

        assertTrue(guessRegex.matches(getElement) && getElement.toSet().size == 3)
    }

    override fun runMain() {
        main()
    }
}
