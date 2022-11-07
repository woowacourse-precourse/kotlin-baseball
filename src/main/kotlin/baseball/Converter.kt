package baseball

interface InputConverter {
    fun convertInput(questionType: Int, input: String): Any?
}