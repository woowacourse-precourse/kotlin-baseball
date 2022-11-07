package baseball

class InputVerifier {
    fun playerNumber(input: List<Int>): List<Int> {
        if (isOutOfRange(input) || isOutOfSize(input) || hasDuplicatedNumber(input)) {
            throw IllegalArgumentException()
        }
        return input
    }

    fun exitNumber(input: Int): Int {
        if (input !in 1..2) {
            throw IllegalArgumentException()
        }
        return input
    }

    private fun isOutOfRange(input: List<Int>): Boolean = input.contains(0)

    private fun isOutOfSize(input: List<Int>): Boolean = (input.size != 3)

    private fun hasDuplicatedNumber(input: List<Int>): Boolean = (input.size != input.distinct().count())
}