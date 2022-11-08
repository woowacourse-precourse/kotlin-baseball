package baseball

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ComputerPlayerTest {
    @Nested
    @DisplayName("생성자에 ComputerRandomNumber 인스턴스를 인자로 넘긴 ComputerPlayer의 인스턴스는")
    inner class ComputerPlayerConstructorWithParameter {
        @DisplayName("3자리 난수를 생성한다")
        @Test
        fun getThreeDigitsNumber() {
            val computerPlayer: Player = ComputerPlayer(ComputerRandomNumber())
            Assertions.assertFalse(computerPlayer.getSelectedNumber().isEmpty())
            Assertions.assertEquals(computerPlayer.getSelectedNumber().length, 3)
        }
    }
}
