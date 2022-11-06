package baseball

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
class ComputerTest {

    @Test
    fun `컴퓨터 랜덤값 생성`() {
        val random = RandomTest()
        random.createRandomValue("201")
        val computerNumber = random.randomValue
        val result = "202"
        Assertions.assertEquals(result, computerNumber,)
    }
}
