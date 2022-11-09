package baseball

import baseball.util.interfaces.RandomUtil

class RandomTest : RandomUtil {
    var randomValue = ""

    fun createRandomValue(number: String) {
        this.randomValue = number
    }

    override fun generate(): String {
        return randomValue
    }
}
