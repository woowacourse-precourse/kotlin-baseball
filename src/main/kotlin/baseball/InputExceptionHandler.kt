package baseball

object InputExceptionHandler {
    private const val STATUS_NUMBER_EXCEPTION = "[ERROR] 1혹은 2를 입력하세요."
    private const val INPUT_NUMBER_EXCEPTION = "[ERROR] 중복이 아닌 3개의 숫자를 입력하세요."

    /**
     * 게임 재시작 or 종료 예외처리 함수
     * */
    fun checkInputStatusNumber(inputStatusNumber: String) {
        if (!validateStatusNumberDigit(inputStatusNumber)) {
            throw IllegalArgumentException(STATUS_NUMBER_EXCEPTION)
        }
        if (!validateStatusNumberLength(inputStatusNumber)
            or !validateStatusNumberCorrect(inputStatusNumber)
        ) {
            throw IllegalArgumentException(STATUS_NUMBER_EXCEPTION)
        }
    }

    private fun validateStatusNumberDigit(inputStatusNumber: String): Boolean {
        return inputStatusNumber.all { it.isDigit() }
    }

    private fun validateStatusNumberLength(inputStatusNumber: String): Boolean {
        return inputStatusNumber.length <= 1
    }

    private fun validateStatusNumberCorrect(inputStatusNumber: String): Boolean {
        return (inputStatusNumber == "1") or (inputStatusNumber == "2")
    }

    /**
     * 야구 게임 입력 숫자 예외처리 함수
     * */
    fun checkInputNumber(inputNumber: String) {
        if (!validateInputNumberDigit(inputNumber)) {
            throw IllegalArgumentException(INPUT_NUMBER_EXCEPTION)
        }
        if (!validateInputNumberLength(inputNumber) or
            !validateInputNumberRepeat(inputNumber)
        ) {
            throw IllegalArgumentException(INPUT_NUMBER_EXCEPTION)
        }
    }

    /**
     * 게임 중 입력되는 서로다른 3가지 숫자 예외처리 함수들
     * */
    private fun validateInputNumberDigit(inputNumber: String): Boolean {
        return inputNumber.all { it.isDigit() }
    }

    private fun validateInputNumberLength(inputNumber: String): Boolean {
        return inputNumber.length == 3
    }

    private fun validateInputNumberRepeat(inputNumber: String): Boolean {
        return (inputNumber[0] != inputNumber[1]) and
                (inputNumber[1] != inputNumber[2]) and
                (inputNumber[0] != inputNumber[2])
    }
}