package baseball

interface InputConverter {
    fun convertInput(questionType: Int, input: String): Any?
}

class BaseballGameInputConverter : InputConverter {
    private fun convertCurRoundInput(input: String): List<Int> = input.map { it.code - 48 }
    private fun convertRestartGameInput(input: String): Int = input.toInt()
    override fun convertInput(questionType: Int, input: String): Any? =
        when (questionType) {
            INPUT_CUR_ROUND -> convertCurRoundInput(input)
            INPUT_RESTART_GAME -> convertRestartGameInput(input)
            else -> null
        }

    companion object {
        const val INPUT_CUR_ROUND = 0
        const val INPUT_RESTART_GAME = 1
    }
}