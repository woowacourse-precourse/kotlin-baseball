package baseball

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("ComputerRandomNumber 클래스")
class ComputerRandomNumberTest {

    @DisplayName("randomNumber에 3자리 난수가 생성됐는지 확인한다")
    @Test
    fun getThreeDigitsNumber() {
        val computerRandomNumber = ComputerRandomNumber()
        Assertions.assertFalse(computerRandomNumber.randomNumber.isEmpty())
        Assertions.assertEquals(computerRandomNumber.randomNumber.length, 3)
    }
}
