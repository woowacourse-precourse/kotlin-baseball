package baseball

class Computer(private val generator: Generator) {
    private val numberLocations = mutableListOf(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1)

    fun generateNumbers() {
        val numbers = generator.generateNumbers(3)
        numbers.withIndex()
            .map { (index, number) -> numberLocations[number] = index }
    }

    fun countBallsStrikes(numbers: List<Int>): BallsStrikes {
        return BallsStrikes(0, 0)
    }

    fun isWin(ballsStrikes: BallsStrikes): Boolean {
        return false
    }
}