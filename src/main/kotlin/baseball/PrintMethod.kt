package baseball
import baseball.Constant.Companion.nothingMessage
import baseball.Constant.Companion.strikeMessage
import baseball.Constant.Companion.ballMessage
import baseball.Constant.Companion.inputNumberMessage


class PrintMethod {
    fun printInputNum(){
        println(inputNumberMessage)
    }


    fun printBallCount(ballCount:Int, strikeCount: Int){
        if (ballCount > 0 && strikeCount > 0) print("$ballCount${ballMessage} ")
        if (ballCount > 0 && strikeCount == 0) println("$ballCount${ballMessage}")
    }

    fun printStrikeCount(strikeCount:Int){
        if (strikeCount > 0) println("$strikeCount${strikeMessage}")
    }

    fun printNothing(ballCount: Int, strikeCount: Int){
        if (ballCount == 0 && strikeCount == 0) println(nothingMessage)
    }
}