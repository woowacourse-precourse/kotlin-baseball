package baseball

import baseball.Message.*
import baseball.RestartDecision.*

fun main() {
    println(WELCOME.message)
    do {
        gameStart()
        println(REQUEST_DECISION_ABOUT_RESTART.message)
    } while (readAnswerAboutRestart() == YES)
}
