package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows

class BaseballModelTest {

    private lateinit var baseballModel: BaseballModel

    @BeforeEach
    fun setUp() {
        baseballModel = BaseballModel()
    }

    @Test
    fun `checkBalls 및 setResultString메소드가 425가 제시된 숫자일 때 올바른 결과값을 반환하는지 체크`() {
        baseballModel.computerNum = listOf(4, 2, 5)

        val testInputs = listOf<String>("123", "456", "789")
        val testResults = listOf<String>("1스트라이크", "1볼 1스트라이크", "낫싱")
        val testStrikes = listOf<Int>(1, 1, 0)
        val testBalls = listOf<Int>(0, 1, 0)

        with(baseballModel) {
            computerNum = listOf(4, 2, 5)
            testInputs.forEachIndexed { idx, case ->
                checkBalls(case)
                setResultString()
                assertThat(resultString).isEqualTo(testResults[idx])
                assertThat(ballResult.strikeCnt).isEqualTo(testStrikes[idx])
                assertThat(ballResult.ballCnt).isEqualTo(testBalls[idx])
                clearGame()
            }
        }
    }

    @Test
    fun `setResultString메소드에서 스트라이크 볼에 따른 올바른 값을 반환하는지 체크`() {
        val testResults = listOf<String>(
            "1볼 2스트라이크", "3볼", "2스트라이크", "낫싱"
        )
        val testStrikes = listOf<Int>(2, 0, 2, 0)
        val testBalls = listOf<Int>(1, 3, 0, 0)

        with(baseballModel) {
            testResults.forEachIndexed { idx, case ->
                ballResult.strikeCnt = testStrikes[idx]
                ballResult.ballCnt = testBalls[idx]
                setResultString()
                assertThat(resultString).isEqualTo(case)
            }
        }
    }

    @Nested
    inner class UserInputTest {
        @Test
        fun `checkBasballNumber 메소드에서 3자리 숫자가 아닌 값이 입력됬을 때 IllegalArgumentException을 발생시킨다`() {
            val testInputs = listOf("1234", "53", "1", "4123123123512312312312313122312312312312312312314123123", "")
            testInputs.forEach { case ->
                assertThrows<IllegalArgumentException>(
                    "$case 3자리가 아니거나, 숫자가 아닌 값"
                ) {
                    baseballModel.checkBasballNumber(case)
                }
            }
        }

        @Test
        fun `checkBasballNumber 메소드에서 숫자가 아닌 값이 입력됬을 때 IllegalArgumentException을 발생시킨다`() {
            val testInputs = listOf("asd", "d221sf", "간12", "", " ", "@!2")
            testInputs.forEach { case ->
                assertThrows<IllegalArgumentException>(
                    "$case 3자리가 아니거나, 숫자가 아닌 값"
                ) {
                    baseballModel.checkBasballNumber(case)
                }
            }
        }

        @Test
        fun `checkBasballNumber 메소드에서 각각 다른 3자리 숫자가 아닐 때 IllegalArgumentException을 발생시킨다`() {
            val testInputs = listOf("121", "333", "454", "666")
            testInputs.forEach { case ->
                assertThrows<IllegalArgumentException>(
                    "$case 각각 다른 3자리 숫자가 아님"
                ) {
                    baseballModel.checkBasballNumber(case)
                }
            }
        }

        @Test
        fun `checkEndedNumber메소드에서 1이나 2가아닌 문자가 들어왔을 때 IllegalArgumentException을 발생시킨다`() {
            val testInputs = listOf("3", "432", "", "aasd")
            testInputs.forEach { case ->
                assertThrows<IllegalArgumentException>() {
                    baseballModel.checkEndedNumber(case)
                }
            }
        }
    }


}