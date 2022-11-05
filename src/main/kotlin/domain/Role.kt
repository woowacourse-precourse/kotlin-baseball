package domain

import utils.Constants
import utils.ExceptionHandler.validateDuplicatedOrException
import utils.ExceptionHandler.validateListLengthOrException

abstract class Role(
    internal val numbers: List<Int>
) {
    fun validate(other: Role) {
        validateListLengthOrException(numbers, Constants.DIGIT_LENGTH)
        validateDuplicatedOrException(numbers, other.numbers)
    }

    fun find(index: Int): Int = numbers[index]
    fun contains(number: Int): Boolean = numbers.contains(number)
    fun isEquals(index: Int, number: Int): Boolean = (find(index) == number)
}