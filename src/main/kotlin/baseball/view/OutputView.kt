package baseball.view

import baseball.model.Judgment
import baseball.model.NumberGenerator
import baseball.OutputMessage

class OutputView {
    fun gameStart(){
        println(OutputMessage.GAME_START.message)
    }

}