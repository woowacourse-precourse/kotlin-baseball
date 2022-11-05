package model

import utils.Constants
import utils.ExceptionHandler.validateDuplicatedOrException
import utils.ExceptionHandler.validateListLengthOrException

abstract class Role(
    internal val numbers: List<Int>
) {

    init {
        validate()
    }

    fun validate() {
        validateListLengthOrException(numbers, Constants.DIGIT_LENGTH)
        validateDuplicatedOrException(numbers)
    }

    fun find(index: Int): Int = numbers[index]
    fun contains(number: Int): Boolean = numbers.contains(number)
    fun isEquals(index: Int, number: Int): Boolean = (find(index) == number)
}