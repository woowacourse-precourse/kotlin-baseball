package baseball

import baseball.Message.*
import baseball.Restart.*

fun main() {
    println(WELCOME.message)
    do {
        gameStart()
        println(REQUEST_DECISION_ABOUT_REPLAY.message)
    } while (readAnswerAboutRestart() == YES)
}
