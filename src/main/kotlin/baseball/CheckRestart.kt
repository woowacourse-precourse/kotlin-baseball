package baseball

import camp.nextstep.edu.missionutils.Console

class CheckRestart {
    fun check(strike: Int) {
        showFinishMessage(strike)
        checkGameRestart(Console.readLine().trim())
        return
    }
}

private fun showFinishMessage(strike: Int) {
    println("${strike}${PrintText.STRIKE}")
    println(PrintText.FINISH_MESSAGE)
    println(PrintText.RESTART_MESSAGE)
}

private fun checkGameRestart(command: String) {
    when (command) {
        PrintText.RESTART_COMMAND -> {
            CreateNumber().create()
        }
        PrintText.FINISH_COMMAND -> {
            return
        }
        else -> {
            throw IllegalArgumentException(PrintText.INVALID_INPUT)
        }
    }
}

