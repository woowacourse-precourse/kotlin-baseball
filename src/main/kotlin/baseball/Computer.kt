package baseball

class Computer(private val generator: Generator) {
    private val numberLocations = mutableListOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1)

    fun generateNumbers() {
        val numbers = generator.generateNumbers(3)
        numbers.withIndex().map { (index, number) -> numberLocations[number] = index }
    }

    fun countBallsStrikes(numbers: List<Int>): BallsStrikes {
        var balls = 0
        var strikes = 0
        for ((location, number) in numbers.withIndex()) {
            if (numberLocations[number] == location) {
                strikes++
                continue
            }

            if (numberLocations[number] != -1) {
                balls++
            }
        }
        return BallsStrikes(balls, strikes)
    }

    fun isWin(ballsStrikes: BallsStrikes): Boolean {
        return false
    }
}