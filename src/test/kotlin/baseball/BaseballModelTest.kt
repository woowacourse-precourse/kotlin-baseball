package baseball

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.assertThrows

internal class BaseballModelTest {

    private lateinit var baseballModel: BaseballModel

    @BeforeEach
    fun setUp() {
        baseballModel = BaseballModel()
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
        fun `checkEndedNumber메소드에서 1이나 2가아닌 문자가 들어왔을 때 IllegalArgumentException을 발생시킨다.`() {
            val testInputs = listOf("3", "432", "", "aasd")
            testInputs.forEach { case ->
                assertThrows<IllegalArgumentException>() {
                    baseballModel.checkEndedNumber(case)
                }
            }
        }
    }


}