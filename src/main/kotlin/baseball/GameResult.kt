package baseball

class GameResult {

    var strike : Int = 0
    var ball : Int = 0

    fun setResult(result  : Result) {
        when(result) {
            Result.STRIKE -> strike++
            Result.BALL -> ball++
        }
    }
}