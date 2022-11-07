package baseball

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class BaseballFunctionTest {
    @Test
    fun `randomStartNumber~randomEndNumber 까지의 각기 다른 무작위수 randomsLength개를 가진 mutableList 반환`() {
        val randomNumbers = getRandomNumbers()
        assertAll("getRandomNumbers가 정확히 구현되어 있는지 검사",
            { assertThat(randomNumbers.distinct().size).isEqualTo(randomNumbers.size) },
            { assertThat(randomNumbers.size).isEqualTo(3) },
            { assertThat(randomNumbers).allMatch { number -> (1..9).contains(number) } })
    }

    @Test
    fun `inputStartNumber~inputEndNumber 까지의 각기 다른 무작위수 stringLengthToSpecify개를 바르게 입력시 mutableList 반환 틀리게 입력시 IllegalArgumentException를 반환`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { validateInputString("1234") }
            assertThrows<IllegalArgumentException> { validateInputString("1a4") }
            assertThrows<IllegalArgumentException> { validateInputString("114") }
            assertThrows<IllegalArgumentException> { validateInputString("123443") }
            assertThrows<IllegalArgumentException> {
                validateInputString(
                    "132", inputStartNumber = 1, inputEndNumber = 2
                )
            }
            assertThrows<IllegalArgumentException> {
                validateInputString("123", stringLengthToSpecify = 1)
            }
        }
    }

    @Test
    fun `컴퓨터와 플레이어의 숫자들을 비교하여 스트라이크 볼 또는 낫싱 문자열을 반환하는 기능`() {
        val computerNumbersExample = mutableListOf(4, 2, 3)
        val playerNumbersExample1 = mutableListOf(1, 5, 3)
        val playerNumbersExample2 = mutableListOf(4, 3, 2)
        val playerNumbersExample3 = mutableListOf(1, 5, 8)
        val playerNumbersExample4 = mutableListOf(3, 4, 2)

        assertAll("getBaseballResult가 정확히 구현되어 있는지 검사",
            { assertThat(getBaseballResult(computerNumbersExample, playerNumbersExample1)).isEqualTo("1스트라이크") },
            { assertThat(getBaseballResult(computerNumbersExample, playerNumbersExample2)).isEqualTo("2볼 1스트라이크") },
            { assertThat(getBaseballResult(computerNumbersExample, playerNumbersExample3)).isEqualTo("낫싱") },
            { assertThat(getBaseballResult(computerNumbersExample, playerNumbersExample4)).isEqualTo("3볼 ") })
    }

    @Test
    fun `게임에서 승리 하였을시 계속할지 그만둘지 선택하는 기능`() {

        val stopExample1 = chooseToContinueOrStop("3스트라이크", "1")
        val stopExample2 = chooseToContinueOrStop("3스트라이크", "2")

        assertAll("getBaseballResult가 정확히 구현되어 있는지 검사",
            { assertThat(stopExample1).isEqualTo(false) },
            { assertThat(stopExample2).isEqualTo(true) })
    }
}