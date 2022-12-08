package baseball

class InputValidate {
    fun baseballNumbersForm(input: String) {
        require(BASEBALL_NUMBERS_FORM.toRegex().matches(input)) { println(ErrorMessage.BASEBALL_NUMBERS_FORM) }
    }

    fun duplicateBaseballNumbers(input: String) {
        val input = input.toCharArray()
        require(input.size == input.distinct().size) { println(ErrorMessage.DUPLICATE_BASEBALL_NUMBERS) }
    }

    fun restartNumber(input: String) {
        require(RESTART_NUMBER_FORM.toRegex().matches(input)) { println(ErrorMessage.RESTART_NUMBER) }
    }

    companion object {
        const val BASEBALL_NUMBERS_FORM = "^[1-9]{3}\$"
        const val RESTART_NUMBER_FORM = "^[1-2]\$"
    }

}