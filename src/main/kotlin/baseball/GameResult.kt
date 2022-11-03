package baseball

class GameResult {

    var strike : Int = 0
    var ball : Int = 0

    fun setResult(result  : String) {
        when(result) {
            "Strike" -> strike++
            "Ball" -> ball++
        }
    }
}