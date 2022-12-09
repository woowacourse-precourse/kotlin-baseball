package view

enum class OutputMessage(val message : String){
    GAME_START("숫자 야구 게임을 시작합니다."),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");


    fun getStrike(strike : Int) : String{
        return strike.toString() + this.message
    }

    fun getBall(ball : Int) : String{
        return ball.toString() + this.message
    }

    fun getStrikeBall(strike : Int, ball : Int) : String{
        return ball.toString() + BALL.message + " " +strike.toString() + STRIKE.message
    }

}
class OutputView {
    fun showStart(){
        println(OutputMessage.GAME_START.message)
    }

    fun showBaseballMessage(pairInfo : Pair<Int, Int>){
        val strike = pairInfo.first
        val ball = pairInfo.second

        if (strike != 0 && ball != 0){
            println(OutputMessage.BALL.getStrikeBall(strike, ball))
        }
        else if (strike == 0 && ball != 0){
            println(OutputMessage.BALL.getBall(ball))
        }
        else if (strike != 0){
            println(OutputMessage.STRIKE.getStrike(strike))
        }
        else println(OutputMessage.NOTHING.message)
    }

}