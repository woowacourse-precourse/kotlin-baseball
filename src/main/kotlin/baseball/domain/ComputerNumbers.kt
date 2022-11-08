package baseball.domain

data class ComputerNumbers(val computerNumbers: MutableList<Int> = mutableListOf()) {

    init {
            while (computerNumbers.size < 3) {
                val randomNumber = RandomNumber()
                if (!computerNumbers.contains(randomNumber.value())) {
                    computerNumbers.add(randomNumber.value())
                }
            }
    }

    fun contains(number: Int): Boolean = computerNumbers.contains(number)

    fun size(): Int = computerNumbers.size

    operator fun get(index: Int): Int = computerNumbers[index]
}

