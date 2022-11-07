package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class BaseballGameTest {
    @Test
    fun `모두 스트라이크일 때 스트라이크 3개 반환`() {
        assertCheck(COMPUTER_INPUT_ONE_TWO_THREE, "123", EXPECTED_THREE_STRIKE, EXPECTED_NONE_BALL)
    }

    @Test
    fun `모두 볼일 때 볼 3개 반환`() {
        assertCheck(COMPUTER_INPUT_ONE_TWO_THREE, "312", EXPECTED_NONE_STRIKE, EXPECTED_THREE_BALL)
    }

    @Test
    fun `모두 오답일 때 낫싱을 반환`() {
        assertCheck(COMPUTER_INPUT_ONE_TWO_THREE, "456", EXPECTED_NONE_STRIKE, EXPECTED_NONE_BALL)

    }

    @Test
    fun `사용자가 잘못된 값을 입력했을 때 IllegalArgumentException 반환`() {
        assertThrows<IllegalArgumentException> {
            throw IllegalArgumentException("잘못된 입력입니다.")
            assertCheck(COMPUTER_INPUT_ONE_TWO_THREE, "1234", EXPECTED_NONE_STRIKE, EXPECTED_ONE_BALL)
        }
    }

    @Test
    fun `오답 2개, 볼 1개일 때 볼 1개 반환`() {
        assertCheck(COMPUTER_INPUT_ONE_TWO_THREE, "782", EXPECTED_NONE_STRIKE, EXPECTED_ONE_BALL)
    }

    @Test
    fun `오답 2개, 스트라이크 1개일 때 스트라이크 1개 반환`() {
        assertCheck(COMPUTER_INPUT_ONE_TWO_THREE, "783", EXPECTED_ONE_STRIKE, EXPECTED_NONE_BALL)
    }

    @Test
    fun `오답 1개, 볼 2개일 때 볼 2개 반환`() {
        assertCheck(COMPUTER_INPUT_ONE_TWO_THREE, "412", EXPECTED_NONE_STRIKE, EXPECTED_TWO_BALL)
    }

    @Test
    fun `오답 1개, 스트라이크 2개일 때 스트라이크 2개 반환`() {
        assertCheck(COMPUTER_INPUT_ONE_TWO_THREE, "423", EXPECTED_TWO_STRIKE, EXPECTED_NONE_BALL)
    }

    @Test
    fun `볼이 2개, 스트라이크 1개일 때 볼 2개,스트라이크 1개 반환`() {
        assertCheck(COMPUTER_INPUT_ONE_TWO_THREE, "132", EXPECTED_ONE_STRIKE, EXPECTED_TWO_BALL)
    }

    @Test
    fun `볼이 1개, 스트라이크 1개, 오답 1개일 때 볼 1개,스트라이크 1개 반환`() {
        assertCheck(COMPUTER_INPUT_ONE_TWO_THREE, "243", EXPECTED_ONE_STRIKE, EXPECTED_ONE_BALL)
    }


    private fun assertCheck(
        computerInput: String,
        userInput: String,
        expectedStrike: Int,
        expectedBall: Int,
    ) {
        val round = Baseball(computerInput)
        val checkStrike = round.strike(userInput)
        val checkBall = round.ball(userInput)
        assertThat(expectedStrike).isEqualTo(checkStrike)
        assertThat(expectedBall).isEqualTo(checkBall)
    }
}

const val EXPECTED_NONE_BALL = 0
const val EXPECTED_ONE_BALL = 1
const val EXPECTED_TWO_BALL = 2
const val EXPECTED_THREE_BALL = 3

const val EXPECTED_NONE_STRIKE = 0
const val EXPECTED_ONE_STRIKE = 1
const val EXPECTED_TWO_STRIKE = 2
const val EXPECTED_THREE_STRIKE = 3

const val COMPUTER_INPUT_ONE_TWO_THREE = "123"