package baseball

val consoleManager = ConsoleManager()
fun main() {
    launchApplication()
}
fun launchApplication() {
    var userInputOfConsole: String
    do{
        startBaseballGame()

        consoleManager.writeLine("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n")

        userInputOfConsole = consoleManager.readLine()
        validateReStartInput(userInputOfConsole)
    } while(userInputOfConsole == "1")
}

fun startBaseballGame() {
    val baseballComputer = NumberBaseballComputer()

    consoleManager.writeLine("숫자 야구 게임을 시작합니다.\n")

    while(baseballComputer.isPoweredOn()) {

        consoleManager.writeLine("숫자를 입력해주세요 : ")

        val requestMessage = consoleManager.readLine()
        baseballComputer.receiveUserMessage(requestMessage)

        val responseMessage = baseballComputer.getResponse()
        consoleManager.writeLine(responseMessage + "\n")
    }
}
fun validateReStartInput(input: String) {
    if(input != "1" && input != "2")
        throw IllegalArgumentException("input is not 1 or 2")
}
