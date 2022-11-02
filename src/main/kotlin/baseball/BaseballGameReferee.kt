package baseball

object BaseballGameReferee {
    fun decideEachTurn(userInput: Int) {

    }

    fun calcStrikeCount(userInput: ArrayList<Int>): Int {
        var strikeCount = 0

        userInput.forEachIndexed { index, eachNum ->
            if (Computer.randomNumbers[index] == eachNum) {
                strikeCount++
            }
        }
        return strikeCount
    }

    fun calcBallCount(userInput: ArrayList<Int>): Int {
        var ballCount = 0

        userInput.forEachIndexed { userIndex, userNum ->
            ballCount+=Computer.randomNumbers.filterIndexed { computerIndex, _ -> computerIndex != userIndex }
                .filter { computerNum -> computerNum == userNum }.size
        }
        return ballCount
    }

    fun checkException(userInput: String) {
        var isValid = true

        when {
            userInput.length != 3 -> isValid = false
            !isNumeric(userInput) -> isValid = false
        }
        if (!isValid) {
            throw IllegalArgumentException("입력 오류입니다.")
        }
    }

    fun isNumeric(userInput: String): Boolean {
        return userInput.chars().allMatch { eachChar -> Character.isDigit(eachChar) }
    }

}