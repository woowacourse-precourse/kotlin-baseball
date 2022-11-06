package baseball

import baseball.domain.Match
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.reflect.Method

class MatchTest {

    @Test
    fun `정상적을 hint 값이 나오는가?`() {
        // given
        val playerNumber = listOf("123", "456", "678", "912")
        val numberList = listOf("459", "564", "687", "912")
        val computerNumber = mutableListOf<String>()

        val random = RandomTest()
        for (i in 0 until NUMBER_OF_TESTS) {
            random.createRandomValue(numberList[i])
            computerNumber.add(random.randomValue)
        }

        // when
        val match = Match()
        val method: Method = match.javaClass.getDeclaredMethod("printHint")
        method.isAccessible = true
        val hint = mutableListOf<String>()
        for (i in 0 until NUMBER_OF_TESTS) {
            match.startWith(computerNumber[i], playerNumber[i])
            hint.add(method.invoke(match) as String)
        }

        // then
        val result = listOf("낫싱", "3볼 ", "2볼 1스트라이크", "3스트라이크")
        for (i in 0 until NUMBER_OF_TESTS) {
            Assertions.assertEquals(result[i], hint[i])
        }
    }

    companion object {
        const val NUMBER_OF_TESTS = 4
    }
}
