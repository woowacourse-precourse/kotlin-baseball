package view


enum class InputMessage(val message : String){
    NUM_INPUT("숫자를 입력해 주세요 : "),
    RESTART_FINISH("게임을 시작하려면 1, 종료하려면 2를 입력하세요.")
}

class InputView {
    fun showInput(){
        print(InputMessage.NUM_INPUT.message)
    }

    fun showRestartOrFinish(){
        println(InputMessage.RESTART_FINISH.message)
    }
}