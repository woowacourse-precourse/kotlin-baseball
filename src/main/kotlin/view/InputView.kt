package view


enum class InputMessage(val message : String){
    NUM_INPUT("숫자를 입력해 주세요 : ")
}

class InputView {
    fun showInput(){
        print(InputMessage.NUM_INPUT.message)
    }
}