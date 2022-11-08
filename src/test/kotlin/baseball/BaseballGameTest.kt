package baseball

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.reflect.InvocationTargetException

class BaseballGameTest : NsTest() {
    lateinit var baseballGame: BaseballGame

    @BeforeEach
    fun `baseballGame 초기화`() {
        baseballGame = BaseballGame(ComputerNumbers(mapOf(1 to 0, 3 to 1, 5 to 2)))
    }

    @Test
    fun `String에 대한 확장 함수인 isNumberString을 사용해 해당 String이 숫자 문자로만 이루어져 있는지 판단`() {
        val input = "a123"
        val result = with(baseballGame) {
            input.isNumberString()
        }
        assertThat(result).isEqualTo(false)
    }

    @Test
    fun `checkValidInput 메서드를 사용해 사용자 입력이 올바르지 않으면 IllegalArgumentException 예외 발생`() {
        val method =
            baseballGame.javaClass.getDeclaredMethod("checkValidInput", String::class.java)
        method.isAccessible = true

        val input = "1234"
        assertThrows<IllegalArgumentException> {
            try {
                method.invoke(baseballGame, input)
            } catch (e: InvocationTargetException) {
                throw e.targetException
            }
        }
    }

    @Test
    fun `decideRestartOrQuit 메서드를 통해 사용자에게 재시작 여부를 입력받는데 올바르지 못한 입력을 받을 경우`() {
        assertThrows<IllegalArgumentException> {
            try {
                run("3")
            } catch (e: InvocationTargetException) {
                throw e.targetException
            }
        }
    }

    @Test
    fun `decideRestartOrQuit 메서드를 통해 재시작 입력을 받았을 때 컴퓨터가 생각하는 숫자를 변경`() {
        val beforeComputerNumbers = baseballGame.computerNumbers
        run("${BaseballSetting.START_OR_RESTART.number}")
        assertThat(beforeComputerNumbers === baseballGame.computerNumbers)
            .isEqualTo(false)
    }

    override fun runMain() {
        val method =
            baseballGame.javaClass.getDeclaredMethod("decideRestartOrQuit")
        method.isAccessible = true
        method.invoke(baseballGame)
    }


}