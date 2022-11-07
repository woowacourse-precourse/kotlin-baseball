package baseball

abstract class InputValidCheckAndConverter(private val inputConverter: InputConverter) {
    fun inputValidCheckAndConvert(questionType: Int, input: String): Any? {
        if (!inputValidCheck(questionType, input)) isNotValidThrowException()
        return inputConverter.convertInput(questionType, input)
    }

    protected abstract fun inputValidCheck(questionType: Int, input: String): Boolean
    protected abstract fun isNotValidThrowException()
}