package baseball

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("HumanPlayer 클래스")
class HumanPlayerTest {
    @Nested
    internal inner class HumanPlayerSelectedNumber {
        @DisplayName("3자리 자연수이면 정상적으로 humanSelectedNumber에 값을 할당한다")
        @ParameterizedTest
        @CsvSource(value = ["120", "777", "1000", "34"])
        fun humanPlayerSelectedRightNumber(selectedNumber: String?) {
            val humanPlayer: Player = HumanPlayer()
            humanPlayer.setSelectedNumber(selectedNumber!!)
            Assertions.assertAll(
                Executable { Assertions.assertFalse(humanPlayer.getSelectedNumber().isEmpty()) },
                Executable { Assertions.assertEquals(humanPlayer.getSelectedNumber().length, 3) }
            )
        }
    }
}
