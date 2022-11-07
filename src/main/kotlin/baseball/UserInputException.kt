package baseball

class UserInputException(inputData: String) {
    init {
        if(isNotInteger(inputData))
            throw IllegalArgumentException("입력된 값은 정수가 아닙니다.")

        if(isNegativeNumber(inputData))
            throw IllegalArgumentException("입력된 값은 양수가 아닙니다.")

        if(isNotThreeDigits(inputData))
            throw IllegalArgumentException("입력된 값은 3자리 수가 아닙니다.")
    }

    private fun isNegativeNumber(inputData: String): Boolean {
        return inputData.toInt() < 0
    }

    private fun isNotThreeDigits(inputData: String): Boolean {
        return inputData.length != 3
    }

    private fun isNotInteger(inputData: String): Boolean {
        try{
            inputData.toInt()
        }catch (e: NumberFormatException) {
            return true
        }
        return false
    }
}