package baseball

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class JudgmentTest {
    private lateinit var judgment: Judgment

    @BeforeEach
    fun setup() {
        judgment = Judgment()
    }

    @ParameterizedTest
    @ValueSource(ints = [1,7,8])
    fun `스트라이크 판정 테스트`(number:Int) {

    }

}