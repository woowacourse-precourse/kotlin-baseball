package baseball

fun main() {
    val playerNumbers = PlayerNumber().inputPlayerNumber()
    if (!isNumberException(playerNumbers)) {
        throw IllegalArgumentException()
    }
}

fun isNumberException(number: List<Int>): Boolean {
    return number.size == 3 && isOneToNine(number) && isNotDuplicate(number)
}

fun isOneToNine(number: List<Int>): Boolean {
    return number.all { num -> num >= 1 && num <= 9 }
}

fun isNotDuplicate(number: List<Int>): Boolean {
    return number.size == number.distinct().size
}