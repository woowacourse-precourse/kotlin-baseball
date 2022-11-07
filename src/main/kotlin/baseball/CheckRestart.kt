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
    println("${strike}${VerifyNumber.STRIKE}")
    println("3개의 숫자를 모두 맞히셨습니다! ${VerifyNumber.FINISH_GAME}")
    println("게임을 새로시작하시려면 ${VerifyNumber.RESTART_COMMAND}, 종료하려면 ${VerifyNumber.FINISH_COMMAND}를 입력하세요.")
}

private fun checkGameRestart(command: String) {
    when (command) {
        VerifyNumber.RESTART_COMMAND -> {
            CreateNumber().create()
        }
        VerifyNumber.FINISH_COMMAND -> {
            return
        }
        else -> {
            throw IllegalArgumentException("올바르지 않은 입력값입니다.")
        }
    }
}

