package domain

class Player(
    private val numbers: List<Int> = listOf()
) {
    fun find(index: Int): Int = numbers[index]
    fun contains(number: Int): Boolean = numbers.contains(number)
    fun isEquals(index: Int, number: Int): Boolean = (find(index) == number)
}