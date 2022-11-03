package baseball

fun main() {
    printWelcomeMessage()

    var intentForNewBaseball = true
    while (intentForNewBaseball) {
        playNewBaseball()
        intentForNewBaseball = getIntentForNewBaseball()
    }
}

private fun printWelcomeMessage() {
    println("숫자 야구 게임을 시작합니다.")
}

private fun playNewBaseball() {
    while (true) {
        TODO()
        if (getBallCount() == 3) {
            printGameFinishedMessage()
            break
        }
    }
}

private fun getBallCount(): Int {
    TODO()
}

private fun printGameFinishedMessage() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

private fun getIntentForNewBaseball(): Boolean {
    printNewGameMessage()
    val input = readLine()
    if (input == "1") {
        return true
    }
    if (input == "2") {
        return false
    }
    return getIntentForNewBaseball()
}

private fun printNewGameMessage() {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}