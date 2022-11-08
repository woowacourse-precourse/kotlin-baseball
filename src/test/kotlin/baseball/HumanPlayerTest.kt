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
        @CsvSource(value = ["123", "456", "789"])
        fun humanPlayerSelectedRightNumber(selectedNumber: String) {
            val humanPlayer: Player = HumanPlayer()
            humanPlayer.setSelectedNumber(selectedNumber)
            Assertions.assertAll(
                Executable { Assertions.assertFalse(humanPlayer.getSelectedNumber().isEmpty()) },
                Executable { Assertions.assertEquals(humanPlayer.getSelectedNumber().length, 3) }
            )
        }

        @DisplayName("3자리 자연수가 아니라면 IllegalArgumentException이 발생하고 애플리케이션이 종료된다")
        @ParameterizedTest
        @CsvSource(value = ["-123", "91 4", "1000", "45.6", "test"])
        fun humanPlayerSelectedWrongNumber(selectedNumber: String?) {
            val humanPlayer: Player = HumanPlayer()
            val invalidInput = Assertions.assertThrows(
                IllegalArgumentException::class.java
            ) { humanPlayer.setSelectedNumber(selectedNumber!!) }
            Assertions.assertEquals("유효하지 않은 숫자형식입니다.", invalidInput.message)
        }
    }
}
