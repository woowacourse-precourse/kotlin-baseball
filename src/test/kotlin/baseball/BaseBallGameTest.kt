package baseball

import baseball.domain.Player
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class BaseBallGameTest {
    @Test
    fun `입력 받은 값이 숫자인가?`() {
        val playerNumber = "Kkd12"

        assertThatThrownBy { Player(playerNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("문자가 섞인 입력 값입니다.")
    }

    @Test
    fun `입력받은 값이 세 자리 수인가?`() {
        val playerNumber = "123456"

        assertThatThrownBy { Player(playerNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("세 자리 숫자가 아닙니다.")
    }

    @Test
    fun `입력 받은 값이 서로 다른 수인가?`() {
        val playerNumber = "112"

        assertThatThrownBy { Player(playerNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("중복되는 숫자가 존재합니다.")
    }

    @Test
    fun `입력 받은 값이 1부터 9까지 수 인가?`() {
        val playerNumber = "102"

        assertThatThrownBy { Player(playerNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력 포맷이 일치하지 않습니다. 1부터 9까지 수만 입력해주세요.")
    }
}
