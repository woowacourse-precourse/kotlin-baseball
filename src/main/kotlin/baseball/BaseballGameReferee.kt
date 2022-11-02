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
            ballCount += Computer.randomNumbers.filterIndexed { computerIndex, _ -> computerIndex != userIndex }
                .filter { computerNum -> computerNum == userNum }.size
        }
        return ballCount
    }

    fun checkException(userInput: String) {
        var isValid = true

        when {
            userInput.length != 3 -> isValid = false
            !userInput.isNumeric() -> isValid = false
            !userInput.hasOverlappedNumbers() -> isValid = false
            userInput.contains('0') -> isValid = false
        }

        if (!isValid) {
            throw IllegalArgumentException("입력 오류입니다.")
        }
    }

    private fun String.isNumeric(): Boolean {
        return this.chars().allMatch { eachChar -> Character.isDigit(eachChar) }
    }

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