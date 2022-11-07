package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BaseballGameInputConverterTest {

    @Test
    fun `컨버터의 questionType으로 0을 받을 때 테스트`() {
        val converter = BaseballGameInputConverter()
        val list = converter.convertInput(BaseballGameInputConverter.INPUT_CUR_ROUND, "234") as List<Int>
        assertThat(list).isEqualTo(listOf(2, 3, 4))
    }

    @Test
    fun `컨버터의 questionType으로 1을 받을 때 테스트1`() {
        val converter = BaseballGameInputConverter()
        val list = converter.convertInput(BaseballGameInputConverter.INPUT_RESTART_GAME, "1") as Int
        assertThat(list).isEqualTo(1)
    }

    @Test
    fun `컨버터의 questionType으로 1을 받을 때 테스트2`() {
        val converter = BaseballGameInputConverter()
        val list = converter.convertInput(BaseballGameInputConverter.INPUT_RESTART_GAME, "2") as Int
        assertThat(list).isEqualTo(2)
    }
}