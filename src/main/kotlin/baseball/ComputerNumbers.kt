package baseball

class ComputerNumbers(private val computerNumberMap: Map<Int, Int>) {

    fun compareToUserInput(userInput: String): Pair<Int, Int> {
        var totalStrike = 0
        var totalBall = 0
        for (i in userInput.indices) {
            val (strike, ball) = countStrikeAndBall(number = userInput[i].digitToInt(), index = i)
            totalStrike += strike
            totalBall += ball
        }
        return totalStrike to totalBall
    }

    fun countStrikeAndBall(number: Int, index: Int): Pair<Int, Int> {
        var strike = 0
        var ball = 0
        when {
            computerNumberMap.containsKey(number)
                    && computerNumberMap[number] == index -> strike++
            computerNumberMap.containsKey(number)
                    && computerNumberMap[number] != index -> ball++
        }
        return strike to ball
    }
}