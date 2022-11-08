package baseball

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("BaseballGame 클래스")
internal class BaseballGameTest {
    @Nested
    @DisplayName("컴퓨터 난수, 사람 플레이어가 고른 값이 값이")
    internal inner class HumanPlayerSelectedNumber {
        @DisplayName("3자리 자연수이면 값을 할당한다")
        @ParameterizedTest
        @CsvSource(value = ["120", "777", "1000", "34"])
        fun playerSelectedRightNumber(humanSelectedNumber: String) {
            val humanPlayer: Player = HumanPlayer()
            val computerPlayer: Player = ComputerPlayer(ComputerRandomNumber())
            humanPlayer.setSelectedNumber(humanSelectedNumber)
            Assertions.assertAll(
                Executable {
                    Assertions.assertFalse(humanPlayer.getSelectedNumber().isEmpty())
                },
                Executable {
                    Assertions.assertEquals(humanPlayer.getSelectedNumber().length, 3)
                }
            )
            Assertions.assertAll(
                Executable {
                    Assertions.assertFalse(computerPlayer.getSelectedNumber().isEmpty())
                },
                Executable {
                    Assertions.assertEquals(computerPlayer.getSelectedNumber().length, 3)
                }
            )
        }
    }
}
