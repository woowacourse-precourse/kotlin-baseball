package baseball

class ComputerNumbers(private val computerNumberMap: Map<Int, Int>) {
    fun compareToUserInput(userInput: String): BaseballResult {
        val baseballResult = BaseballResult(0, 0)
        for (i in userInput.indices) {
            baseballResult.plus(
                countStrikeAndBall(number = userInput[i].digitToInt(), index = i)
            )
        }
        return baseballResult
    }

    fun countStrikeAndBall(number: Int, index: Int): BaseballResult {
        var strike = 0
        var ball = 0
        when {
            computerNumberMap.containsKey(number)
                    && computerNumberMap[number] == index -> strike++
            computerNumberMap.containsKey(number)
                    && computerNumberMap[number] != index -> ball++
        }
        return BaseballResult(ball, strike)
    }
}