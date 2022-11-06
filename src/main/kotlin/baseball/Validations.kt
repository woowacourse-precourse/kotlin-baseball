package baseball

class Validations {
    companion object {
        fun isThreeStrike(strike: Int): Boolean =
            strike == Constants.NUMBER_LENGTH

        fun isNumberException(number: List<Int>): Boolean =
            number.size == Constants.NUMBER_LENGTH && isOneToNine(number) && isNotDuplicate(number)

        fun isOneToNine(number: List<Int>): Boolean =
            number.all { num -> num >= Constants.MIN_NUMBER && num <= Constants.MAX_NUMBER }

        fun isNotDuplicate(number: List<Int>): Boolean =
            number.size == number.distinct().size
    }
}