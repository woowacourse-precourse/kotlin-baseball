package baseball

class ExpectedNumberGenerator(private val expect: List<Int>) : Generator {
    override fun generateNumbers(n: Int): List<Int> {
        return expect
    }
}