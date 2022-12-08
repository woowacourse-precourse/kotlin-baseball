package baseball.view

import baseball.model.Judgment
import baseball.model.NumberGenerator
import baseball.OutputMessage

class OutputView {
    fun gameStart(){
        println(OutputMessage.GAME_START.message)
    }

    fun inputNumbers(){
        println(OutputMessage.INPUT_NUMBERS.message)
    }

    fun judgementResult(compareResult:String) {
        println(compareResult)
    }

    fun winGame() {
        println(OutputMessage.THREE_STRIKE.message)
    }

    fun restartGame(){
        println(OutputMessage.QUESTION_RETRY.message)
    }

}