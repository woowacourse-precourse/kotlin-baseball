package baseball

class InputChecker {
    fun checkEndedNumber(userInput: String) {
        val regex = Regex("[1-2]{1}")
        require(userInput.matches(regex)) {
            "1또는 2를 입력해 주세요."
        }
    }

    fun checkBasballNumber(userNum: String) {
        val regex = Regex("[0-9]{3}")
        require(userNum.matches(regex)) {
            "$userNum 3자리가 아니거나, 숫자가 아닌 값"
        }
        require(userNum.toCharArray().distinct().size == 3) {
            "$userNum 각각 다른 3자리 숫자가 아님"
        }
    }
}