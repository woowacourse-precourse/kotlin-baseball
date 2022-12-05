package baseball

import baseball.model.BaseballMaker
import baseball.model.RandomNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class BaseballMakerTest {
    private val baseballMaker = BaseballMaker(RandomNumberGenerator())
    @Test
    fun `난수 세 개 생성 테스트`(){
        val result = baseballMaker.makeBaseball()
        for (index in result.indices)
            Assertions.assertThat(result[index]).isBetween(1,9)
    }
}