package baseball.view.io


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

    fun winGame(win:Boolean) {
        if (win) println(OutputMessage.THREE_STRIKE.message)
    }

    fun restartGame(){
        println(OutputMessage.QUESTION_RETRY.message)
    }

}