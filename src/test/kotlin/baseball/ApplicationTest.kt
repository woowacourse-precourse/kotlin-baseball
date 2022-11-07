package baseball

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

class ApplicationTest : NsTest() {

    @BeforeEach
    fun setUpAnswer() {
        answer = Answer("123")
    }

    @Test
    @DisplayName("Random Number 생성 후 자리수가 3자리가 아닐경우 exception 발생하는지 test")
    fun `Random Number 생성 후 자릿수 검사`() {

        val wrongDigitNumber1 = assertThrows<IllegalArgumentException> { Answer("12") }
        val wrongDigitNumber2 = assertThrows<IllegalArgumentException> { Answer("1244") }

        assertThat(wrongDigitNumber1.message).isEqualTo("number's digit should be 3.")
        assertThat(wrongDigitNumber2.message).isEqualTo("number's digit should be 3.")

    }

    @Test
    @DisplayName("Random Number 생성 후 각 자리수가 unique하지 않을 경우 exception 발생하는지 test")
    fun `Random Number 생성 후 중복 검사`() {

        val dupNumber = assertThrows<IllegalArgumentException> { Answer("122") }

        assertThat(dupNumber.message).isEqualTo("each number in answer should be unique.")

    }


    @Test
    @DisplayName("Player가 입력한 정답이 3자리가 아닐 경우 exception 발생하는지 test")
    fun `Player Guess 자릿수 검사`() {
        val wrongDigitNumber1 = assertThrows<IllegalArgumentException> { PlayersGuess("12") }
        val wrongDigitNumber2 = assertThrows<IllegalArgumentException> { PlayersGuess("1244") }

        assertThat(wrongDigitNumber1.message).isEqualTo("number's digit should be 3.")
        assertThat(wrongDigitNumber2.message).isEqualTo("number's digit should be 3.")

    }

    @Test
    @DisplayName("Player가 입력한 정답에 대해 strike와 ball count를 올바르게 세는지 test")
    fun `Player Guess에 대해 Strike 와 Ball counting`() {
        val guess1 = PlayersGuess("129")
        val guess2 = PlayersGuess("312")
        val guess3 = PlayersGuess("456")
        val guess4 = PlayersGuess("152")

        assertThat(countBallAndStrike(guess1)).isEqualTo(listOf(2, 0))
        assertThat(countBallAndStrike(guess2)).isEqualTo(listOf(0, 3))
        assertThat(countBallAndStrike(guess3)).isEqualTo(listOf(0, 0))
        assertThat(countBallAndStrike(guess4)).isEqualTo(listOf(1, 1))

    }

    @Test
    @DisplayName("strike와 ball count를 올바르게 출력하는지 test")
    fun `Strike 와 Ball count 출력`() {
        val case1 = countBallAndStrike(PlayersGuess("129"))
        val case2 = countBallAndStrike(PlayersGuess("312"))
        val case3 = countBallAndStrike(PlayersGuess("456"))
        val case4 = countBallAndStrike(PlayersGuess("152"))

        assertThat(gameStrings.strikeAndBallCountString(case1[0], case1[1])).isEqualTo("2스트라이크")
        assertThat(gameStrings.strikeAndBallCountString(case2[0], case2[1])).isEqualTo("3볼")
        assertThat(gameStrings.strikeAndBallCountString(case3[0], case3[1])).isEqualTo("낫싱")
        assertThat(gameStrings.strikeAndBallCountString(case4[0], case4[1])).isEqualTo("1볼 1스트라이크")
    }


    @Test
    @DisplayName("정답일 경우 게임을 종료하는지 test")
    fun `정답일 경우 게임 종료`() {
        val correctAnswer = countBallAndStrike(PlayersGuess("123"))

        assertThat(gameStrings.strikeAndBallCountString(correctAnswer[0], correctAnswer[1]))
            .isEqualTo(gameStrings.CORRECT_TEXT)
    }

    @Test
    @DisplayName("정답 이후 사용자 입력이 1 or 2가 아니라면 exception발생하는지 test")
    fun `정답 이후 사용자 입력 exception test`() {
        val exception = assertThrows<java.lang.IllegalArgumentException> { NewGameOrEnd(3) }

        assertThat(exception.message).isEqualTo("input should be 1 or 2.")
    }

    @Test
    @DisplayName("정답 이후 사용자 입력이 1 or 2일 경우 decideNewGameOrEnd가 True/False를 옳게 return하는지 test")
    fun `NewGame or GameStop test`() {
        val newGame = NewGameOrEnd(1)
        val gameStop = NewGameOrEnd(2)

        assertThat(decideNewGameOrEnd(newGame)).isEqualTo(false)
        assertThat(decideNewGameOrEnd(gameStop)).isEqualTo(true)

    }


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

    override fun runMain() {
        main()
    }
}
