package view

enum class OutputMessage(val message : String){
    GAME_START("숫자 야구 게임을 시작합니다.")
}
class OutputView {
    fun showStart(){
        println(OutputMessage.GAME_START.message)
    }
}