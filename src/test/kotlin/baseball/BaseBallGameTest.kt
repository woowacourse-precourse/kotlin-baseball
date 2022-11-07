package baseball

import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class BaseBallGameTest : NsTest() {
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

    @Test
    fun `printGuide 메서드출력 결과 확인`() {
        val baseBallGame = BaseBallGame()
        val method = baseBallGame.javaClass.getDeclaredMethod("printGuide")
        method.isAccessible = true

        val parameters = arrayOfNulls<Any>(0)
        val getElement = method.invoke(baseBallGame, *parameters)
        assertThat(output()).isEqualTo("숫자 야구 게임을 시작합니다.\n숫자를 입력해주세요 :")
    }

    @Test
    fun `checkValidGuess 메서드출력 결과 확인`() {
        val baseBallGame = BaseBallGame()

        val method = baseBallGame.javaClass.getDeclaredMethod("checkValidGuess", String::class.java)
        method.isAccessible = true

        val parameters = arrayOfNulls<Any>(1)

        parameters[0] = "111"
        var getElement = method.invoke(baseBallGame, *parameters)
        assertThat(getElement).isEqualTo(false)

        parameters[0] = "123"
        getElement = method.invoke(baseBallGame, *parameters)
        assertThat(getElement).isEqualTo(true)

        parameters[0] = "121"
        getElement = method.invoke(baseBallGame, *parameters)
        assertThat(getElement).isEqualTo(false)

        parameters[0] = "1211"
        getElement = method.invoke(baseBallGame, *parameters)
        assertThat(getElement).isEqualTo(false)
    }

    @Test
    fun `checkGameOver 메서드출력 결과 확인`() {
        val baseBallGame = BaseBallGame()

        val method = baseBallGame.javaClass.getDeclaredMethod("checkGameOver", BaseBallGame.Score::class.java)
        method.isAccessible = true

        val parameters = arrayOfNulls<Any>(1)

        parameters[0] = BaseBallGame.Score(1,0)
        var getElement = method.invoke(baseBallGame, *parameters)
        assertThat(getElement).isEqualTo(false)

        parameters[0] = BaseBallGame.Score(3,0)
        getElement = method.invoke(baseBallGame, *parameters)
        assertThat(getElement).isEqualTo(true)
    }

    @Test
    fun `gradeGuess 메서드반환 결과 확인`() {
        val baseBallGame = BaseBallGame()

        val method = baseBallGame.javaClass.getDeclaredMethod("gradeGuess", String::class.java, String::class.java)
        method.isAccessible = true

        val parameters = arrayOfNulls<Any>(2)

        parameters[0] = "123"
        parameters[1] = "123"
        var getElement = method.invoke(baseBallGame, *parameters)
        assertThat(getElement).isEqualTo(BaseBallGame.Score(3, 0))

        parameters[0] = "124"
        parameters[1] = "123"
        getElement = method.invoke(baseBallGame, *parameters)
        assertThat(getElement).isEqualTo(BaseBallGame.Score(2, 0))
    }

    @Test
    fun `printScore 메서드출력 결과 확인`() {
        val baseBallGame = BaseBallGame()
        val method = baseBallGame.javaClass.getDeclaredMethod("printScore", BaseBallGame.Score::class.java)
        method.isAccessible = true

        val parameters = arrayOfNulls<Any>(1)

        listOf(
            BaseBallGame.Score(1, 1),
            BaseBallGame.Score(1, 0),
            BaseBallGame.Score(0, 1),
            BaseBallGame.Score(0, 0)
        ).forEach {
            parameters[0] = it
            method.invoke(baseBallGame, *parameters)
        }
        assertThat(output()).containsSequence("1볼 1스트라이크\n", "1스트라이크\n", "1볼\n", "낫싱")
    }

    @Test
    fun `printGameOverMessage 메서드출력 결과 확인`() {
        val baseBallGame = BaseBallGame()
        val method = baseBallGame.javaClass.getDeclaredMethod("printGameOverMessage")
        method.isAccessible = true
        val parameters = arrayOfNulls<Any>(0)
        val getElement = method.invoke(baseBallGame, *parameters)
        assertThat(output()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
    override fun runMain() {
        main()
    }
}
