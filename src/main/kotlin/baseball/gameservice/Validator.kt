package baseball.gameservice

object Validator {
    /** 사용자의 숫자 추즉을 위한 입력이 규칙에 적합한지 확인하는 함수 **/
    fun checkIsValid(userInput: String): Boolean {
        var isValid = true

        when {
            userInput.length != 3 -> isValid = false
            !userInput.isNumeric() -> isValid = false
            !userInput.hasOverlappedNumbers() -> isValid = false
            userInput.contains('0') -> isValid = false
        }

        if (!isValid) {
            ScreenManipulator.closeScreen()
        }
        return isValid
    }

    /** 3STRIKE인 경우 게임을 계속 진행할지에 대한 입력이 규칙에 적합한지 확인하는 함수 **/
    fun checkContinuingIsValid(userInput:String): Boolean {
        when(userInput){
            !in arrayOf("1", "2") -> return false
        }
        return true
    }

    /** 사용자의 입력에 숫자가 아닌 것들이 존재하는지 확인하기 위한 함수 **/
    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { eachChar -> Character.isDigit(eachChar) }
    }

    /** 중복된 숫자들이 있는지 확인하는 함수 **/
    private fun String.hasOverlappedNumbers(): Boolean {
        val usedNumberSet = mutableSetOf<Char>()

        this.forEach { eachNum ->
            if (usedNumberSet.contains(eachNum)) {
                return false
            }
            usedNumberSet.add(eachNum)
        }
        return true
    }
}