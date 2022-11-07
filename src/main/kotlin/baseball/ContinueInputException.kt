package baseball

class ContinueInputException(inputContinue: String) {
    init {
        if(isNotInteger(inputContinue))
            throw IllegalArgumentException("입력된 값은 정수가 아닙니다.")

        if(isNegativeNumber(inputContinue))
            throw IllegalArgumentException("입력된 값은 양수가 아닙니다.")

        if(isNotOneDigits(inputContinue))
            throw IllegalArgumentException("입력된 값은 1자리 수가 아닙니다.")

        if(isNotOneOrTwo(inputContinue))
            throw IllegalArgumentException("입력된 값은 1과 2가 아닙니다.")
    }

    private fun isNegativeNumber(inputContinue: String): Boolean {
        return inputContinue.toInt() < 0
    }

    private fun isNotOneDigits(inputContinue: String): Boolean {
        return inputContinue.length != 1
    }

    private fun isNotOneOrTwo(inputContinue: String): Boolean {
        return !(inputContinue == "1" || inputContinue == "2")
    }

    private fun isNotInteger(inputContinue: String): Boolean {
        try{
            inputContinue.toInt()
        }catch (e: NumberFormatException) {
            return true
        }
        return false
    }
}