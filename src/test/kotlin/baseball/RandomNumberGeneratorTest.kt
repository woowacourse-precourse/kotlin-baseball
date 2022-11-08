package baseball


import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test


class RandomNumberGeneratorTest {
    @Test
    fun `generateNotDuplicatedNumber 메서드로 주어진 Map의 keys와 중복 되지 않는 1~9 사이의 임의의 수 반환`() {
        val input = mapOf(1 to 10, 2 to 10, 3 to 10, 4 to 10, 5 to 10, 6 to 10, 7 to 10, 8 to 10)
        val result = RandomNumberGenerator.generateNotDuplicatedNumber(input)
        assertThat(result).isEqualTo(9)
    }

    @Test
    fun `nDigitMap 메서드를 사용해 1부터 9까지 서로 다른 수로 이루어진 n자리의 수를 표현하는 Map(key가 각 자리의 수, value가 그 수의 위치)을 반환`() {
        val input = 3
        val result = RandomNumberGenerator.nDigitMap(input)
        assertThat(result).hasSize(3)
    }
}