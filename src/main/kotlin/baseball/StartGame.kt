package baseball

class StartGame {
    fun start() {
        showStartMessage()
        CreateNumber().create()
    }
}

private fun showStartMessage() {
    println("숫자 야구 게임을 시작합니다.")
}
