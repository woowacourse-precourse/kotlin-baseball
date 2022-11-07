package baseball

abstract class InputValidCheckAndConverter(private val inputConverter: InputConverter) {
    fun inputValidCheckAndConvert(questionType: Int, input: String): Any? {
        if (!inputValidCheck(questionType, input)) isNotValidThrowException()
        return inputConverter.convertInput(questionType, input)
    }

    protected abstract fun inputValidCheck(questionType: Int, input: String): Boolean
    protected abstract fun isNotValidThrowException()
}

class BaseballInputValidCheckAndConverter(private val inputConverter: InputConverter) :
    InputValidCheckAndConverter(inputConverter) {

    override fun inputValidCheck(questionType: Int, input: String): Boolean =
        when (questionType) {
            BaseballGameInputConverter.INPUT_CUR_ROUND -> curRoundInputValidCheck(input)
            BaseballGameInputConverter.INPUT_RESTART_GAME -> restartGameInputValidCheck(input)
            else -> false
        }

    override fun isNotValidThrowException() {
        throw IllegalArgumentException()
    }

    private fun curRoundInputValidCheck(input: String): Boolean {
        if (input.isNullOrEmpty() ||
            input.length != 3
        ) {
            return false
        }

        input.forEach { if (!isNumberValidRange(it.code - 48)) return false }
        return true
    }

    private fun isNumberValidRange(num: Int): Boolean = num in 1..9

    private fun restartGameInputValidCheck(input: String): Boolean {
        if (input.isNullOrEmpty() ||
            input.length != 1
        ) {
            return false
        }

        return restartAnswerInputValidRange(input)
    }

    private fun restartAnswerInputValidRange(input: String): Boolean = input[0].code == 49 || input[0].code == 50
}