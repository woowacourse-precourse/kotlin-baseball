package baseball

private const val WRONG_INPUT_MESSAGE = "잘못된 입력입니다."
private const val ASCII_ZERO = 48
const val RESTART_CODE = 1
const val EXIT_CODE = 2

class User {

    fun getGuessInput(): List<Int> {
        val input = UserView.getGuessInput()
        val guessNumbers = input.toList().map { it.code.plus(-ASCII_ZERO) }
        if (isGuessInputException(guessNumbers)) {
            throw IllegalArgumentException(WRONG_INPUT_MESSAGE)
        }
        return guessNumbers
    }

    private fun isGuessInputException(guessInput: List<Int>): Boolean {
        if (guessInput.size != ANSWER_COUNT) {
            return true
        }
        guessInput.forEach {
            if (it !in MIN_NUMBER..MAX_NUMBER) {
                return true
            }
        }
        if (guessInput.toSet().size != ANSWER_COUNT) {
            return true
        }
        return false
    }

    fun getRestartOrNotInput(): Int {
        val input = UserView.getRestartInput()
        if (isRestartInputException(input)) {
            throw IllegalArgumentException(WRONG_INPUT_MESSAGE)
        }
        return input.toInt()
    }

    private fun isRestartInputException(restartInput: String): Boolean {
        val integerInput = restartInput.toIntOrNull()
        if (integerInput == RESTART_CODE || integerInput == EXIT_CODE) {
            return false
        }
        return true
    }

}