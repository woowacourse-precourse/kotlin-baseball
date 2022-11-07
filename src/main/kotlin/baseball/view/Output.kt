package baseball.view

import baseball.model.domain.ScoreLog

fun resultReturn(score: ScoreLog) {
    println(score.getScore())
}

fun isComplete(complete: Boolean) {
    if(complete) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}

fun endMessage() = println("게임 종료")

fun startMessage() = println("숫자 야구 게임을 시작합니다.")

private fun isNothing(strike: Int, ball: Int):Boolean {
    if (strike == 0 && ball == 0) {
        return true
    }
    return false
}


