package baseball

class Compare {

    fun checkBallAndStrike(userInputList: List<Int>, answerList: List<Int>): Boolean {
        var strikeCount = 0
        var ballCount = 0
        for (userInputPosition in userInputList.indices) {
            ballCount += checkBallCount(userInputList[userInputPosition], userInputPosition, answerList)
            strikeCount += checkStrikeCount(userInputList[userInputPosition], userInputPosition, answerList)
        }
        Result().printResult(strikeCount, ballCount)
        return strikeCount == GAME_CLEAR
    }

    private fun checkBallCount(userInputEach: Int, userInputPosition: Int, answerList: List<Int>): Int {
        for (answerPosition in answerList.indices) {
            if (answerList[answerPosition] == userInputEach && userInputPosition != answerPosition) {
                return 1
            }
        }
        return 0
    }

    private fun checkStrikeCount(userInputEach: Int, userInputPosition: Int, answerList: List<Int>): Int {
        for (answerPosition in answerList.indices) {
            if (answerList[answerPosition] == userInputEach && userInputPosition == answerPosition) {
                return 1
            }
        }
        return 0
    }
}