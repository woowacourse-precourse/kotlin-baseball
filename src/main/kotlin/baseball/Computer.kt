package baseball

class Computer {
    private val randomNumberGenerator = RandomNumberGenerator()
    private val numberLocations = mutableListOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1)

    fun generateNumbers() {
        val numbers = randomNumberGenerator.generateNumbers(3)
    }

    fun countBallsStrikes(numbers: List<Int>): BallsStrikes {
        return BallsStrikes(0, 0)
    }

    fun isWin(ballsStrikes: BallsStrikes) : Boolean {
        return false
    }
}