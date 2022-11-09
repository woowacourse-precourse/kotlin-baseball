package baseball

import baseball.domain.Match
import baseball.domain.Player
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class MatchTest {

    @Test
    fun `정상적을 hint 값이 나오는가?`() {
        val match = Match()
        val method = match.javaClass.getDeclaredMethod("printHint")
        method.isAccessible = true
        match.startWith(random.generate(), player.number)
        val received = method.invoke(match) as String
        val expected = "낫싱"
        Assertions.assertThat(received).isEqualTo(expected)
    }

    companion object {
        private lateinit var player: Player
        private lateinit var random: RandomTest

        @JvmStatic
        @BeforeAll
        fun `컴퓨터와 플레이어 숫자 가져오기`() {
            player = Player()
            player.saveIfValid("123")
            val result = "123"
            Assertions.assertThat(player.number).isEqualTo(result)

            random = RandomTest()
            random.createRandomValue("456")
            val received = random.generate()
            val expected = "456"
            Assertions.assertThat(received).isEqualTo(expected)
        }
    }
}
