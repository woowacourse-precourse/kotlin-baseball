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


}