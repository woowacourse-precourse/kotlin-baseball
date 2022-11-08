package baseball

class StartGame {
    fun start() {
        showStartMessage()
        CreateNumber().create()
    }
}

private fun showStartMessage() {
    println(PrintText.START_MESSAGE)
}
