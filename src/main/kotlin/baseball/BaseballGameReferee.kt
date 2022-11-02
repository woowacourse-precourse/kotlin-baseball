package baseball

object BaseballGameReferee {
    fun decideEachTurn(userInput: Int) {

    }

    fun calcStrikeCount(userInput: ArrayList<Int>): Int {
        var strikeCount = 0

        userInput.forEachIndexed { index, eachNum ->
            if (Computer.randomNumbers[index] == eachNum){
                strikeCount++
            }
        }

        return strikeCount
    }
}