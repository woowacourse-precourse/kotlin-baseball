package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BaseballInputValidCheckAndConverterTest {

    @Test
    fun `인자로 받은 스트링을 questionType 0일때 유효성 검증 및 변환 테스트`() {
        val validCheckAndConverter = BaseballInputValidCheckAndConverter(BaseballGameInputConverter())
        val result = validCheckAndConverter.inputValidCheckAndConvert(BaseballGameInputConverter.INPUT_CUR_ROUND, "478")
        var isBoolean = false
        if (result == listOf(4, 7, 8)) isBoolean = true
        assertThat(isBoolean).isTrue
    }

    @Test
    fun `인자로 받은 스트링을 questionType 1일때 유효성 검증 및 변환 테스트`() {
        val validCheckAndConverter = BaseballInputValidCheckAndConverter(BaseballGameInputConverter())
        val result =
            validCheckAndConverter.inputValidCheckAndConvert(BaseballGameInputConverter.INPUT_RESTART_GAME, "1")
        assertThat(result).isEqualTo(1)
    }
}