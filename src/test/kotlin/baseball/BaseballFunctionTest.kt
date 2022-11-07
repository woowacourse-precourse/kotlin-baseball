package baseball

import camp.nextstep.edu.missionutils.test.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows

class BaseballFunctionTest {
    @Test
    fun `getRandomNumbers randomStartNumber~randomEndNumber까지의 각기 다른 무작위수 randomsLength개를 가진 mutableList 반환`() {
        val randomNumbers = getRandomNumbers()
        assertAll("getRandomNumbers가 정확히 구현되어 있는지 검사",
            { assertThat(randomNumbers.distinct().size).isEqualTo(randomNumbers.size) },
            { assertThat(randomNumbers.size).isEqualTo(3) },
            { assertThat(randomNumbers).allMatch { number -> (1..9).contains(number) } }
        )
    }

}